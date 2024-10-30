package com.fanci.Hyperion_be.service.serviceImpl;

import com.fanci.Hyperion_be.dto.ProductSubCategoryDto;
import com.fanci.Hyperion_be.dto.request.CreateNewProductCategoryRequest;
import com.fanci.Hyperion_be.dto.response.ProductCategoryResponse;
import com.fanci.Hyperion_be.dto.response.ProductCategoryResponseSimple;
import com.fanci.Hyperion_be.entity.ProductCategory;
import com.fanci.Hyperion_be.entity.ProductSubCategory;
import com.fanci.Hyperion_be.mapper.ProductCategoryMapper;
import com.fanci.Hyperion_be.mapper.ProductSubCategoryMapper;
import com.fanci.Hyperion_be.repository.ProductCategoryRepository;
import com.fanci.Hyperion_be.repository.ProductRepository;
import com.fanci.Hyperion_be.service.ProductCategoryService;
import com.fanci.Hyperion_be.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;

    private final ProductCategoryMapper productCategoryMapper;
    private final ProductSubCategoryMapper productSubCategoryMapper;

    @Override
    public Page<ProductCategoryResponseSimple> findAllProductCategoriesWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productCategoryRepository.findAll(pageable).map(productCategoryMapper::toProductCategoryResponseSimple);
    }

    @Override
    public List<ProductCategoryResponse> findAllProductCategories() {
        List<ProductCategory> productCategoryList = productCategoryRepository.findAll();

        //        productCategoryList.forEach(productCategory1 -> {
//            List<ProductSubCategoryDto> productSubCategoryDtoList = productCategory1.getProductSubCategories().stream().map(this::toProductSubCategoryDto).toList();
//            productCategoryResponseList.forEach(productCategoryResponse -> {
//                productCategoryResponse.setProductSubCategoryDtoList(productSubCategoryDtoList);
//            });
//        });
        return productCategoryList.stream().map(productCategory -> {
            ProductCategoryResponse productCategoryResponse = productCategoryMapper.toProductCategoryResponse(productCategory);
            List<ProductSubCategoryDto> productSubCategoryDtoList = productCategory.getProductSubCategories().stream().map(this::toProductSubCategoryDto).toList();
            productCategoryResponse.setProductSubCategoryDtoList(productSubCategoryDtoList);
            return productCategoryResponse ;
        }).toList();
    }

    private ProductSubCategoryDto toProductSubCategoryDto(ProductSubCategory productSubCategory) {
        ProductSubCategoryDto productSubCategoryDto = productSubCategoryMapper.toProductSubCategoryDto(productSubCategory);
        productSubCategoryDto.setProductResponseList(productService.findAllProductByProductSubCategoryId(productSubCategoryDto.getId()));
        return productSubCategoryDto;
    }


    @Override
    public ProductCategoryResponseSimple addNewProductCategory(CreateNewProductCategoryRequest request) {
        ProductCategory productCategory = productCategoryMapper.toProductCategory(request);
        productCategory.setIsActive(true);
        return productCategoryMapper.toProductCategoryResponseSimple(productCategoryRepository.save(productCategory));
    }
}
