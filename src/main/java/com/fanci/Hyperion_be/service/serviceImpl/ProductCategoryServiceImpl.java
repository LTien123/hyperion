package com.fanci.Hyperion_be.service.serviceImpl;

import com.fanci.Hyperion_be.dto.request.CreateNewProductCategoryRequest;
import com.fanci.Hyperion_be.dto.response.ProductCategoryResponse;
import com.fanci.Hyperion_be.entity.ProductCategory;
import com.fanci.Hyperion_be.mapper.ProductCategoryMapper;
import com.fanci.Hyperion_be.repository.ProductCategoryRepository;
import com.fanci.Hyperion_be.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;

    @Override
    public Page<ProductCategoryResponse> findAllProductCategoriesWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productCategoryRepository.findAll(pageable).map(productCategoryMapper::toProductCategoryResponse);
    }



    @Override
    public ProductCategoryResponse addNewProductCategory(CreateNewProductCategoryRequest request) {
        ProductCategory productCategory = productCategoryMapper.toProductCategory(request);
        productCategory.setIsActive(true);
        return productCategoryMapper.toProductCategoryResponse(productCategoryRepository.save(productCategory)) ;
    }
}
