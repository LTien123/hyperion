package com.fanci.Hyperion_be.service.serviceImpl;

import com.fanci.Hyperion_be.dto.*;
import com.fanci.Hyperion_be.dto.request.CreateNewProductRequest;
import com.fanci.Hyperion_be.dto.response.ProductResponse;
import com.fanci.Hyperion_be.entity.Product;
import com.fanci.Hyperion_be.entity.ProductDetail;
import com.fanci.Hyperion_be.exception.AppException;
import com.fanci.Hyperion_be.exception.ErrorCode;
import com.fanci.Hyperion_be.mapper.*;
import com.fanci.Hyperion_be.repository.ProductRepository;
import com.fanci.Hyperion_be.repository.ProductSubCategoryRepository;
import com.fanci.Hyperion_be.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductSubCategoryRepository productSubCategoryRepository;

    private final ProductMapper productMapper;
    private final ProductDetailMapper productDetailMapper;
    private final ProductSubCategoryDtoMapper productSubCategoryDtoMapper;
    private final ProductCategoryDtoMapper productCategoryDtoMapper;
    private final ProductColorMapper productColorMapper;
    private final ProductMaterialMapper productMaterialMapper;
    private final ProductHandlebarMapper productHandlebarMapper;
    private final ProductImageMapper productImageMapper;


    private final UploadService uploadService;

    @Override
    public Page<ProductResponse> findAllProductByProductSubCategoryName(String productSubCategoryName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        return productRepository.findAllProductByProductSubCategoryNameWithPagination(productSubCategoryName, pageable).map(this::toProductResponse);
    }

    @Override
    public ProductResponse findProductByProductName(String productName) {
        Product product = productRepository.findProductByProductName(productName).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NAME_NOT_FOUND));
        return toProductResponse(product);
    }

    @Override
    @Transactional
    public ProductResponse createNewProduct(CreateNewProductRequest request) throws IOException {
        if (productRepository.findProductByProductName(request.getName()).isPresent()) {
            throw new AppException(ErrorCode.PRODUCT_NAME_DUPLICATED);
        }
        var product = productMapper.toProduct(request);
        product.setIsActive(true);
        product.setCreatedAt(LocalDateTime.now());
        product.setProductSubCategory(productSubCategoryRepository.findById(request.getProductSubCategoryId()).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_SUB_CATEGORY_ID_NOT_FOUND)));
        var newProduct = productRepository.save(product);
        uploadService.uploadThumbnail(newProduct, request.getThumbnail());

        return toProductResponse(newProduct);
    }

    private ProductResponse toProductResponse(Product product) {
        var productResponse = productMapper.toProductResponse(product);
        //add sub category and category
        productResponse.setProductSubCategoryDto(productSubCategoryDtoMapper.toProductSubCategoryDto(product.getProductSubCategory()));
        productResponse.setProductCategoryDto(productCategoryDtoMapper.toProductCategoryDto(product.getProductSubCategory().getProductCategory()));

        //add product detail dto

        if (product.getProductDetails() != null) {
            List<ProductDetailDto> productDetailDtoList = new ArrayList<>();
            for (ProductDetail p : product.getProductDetails()) {

                ProductColorDto productColorDto = productColorMapper.toProductColorDto(p.getProductColor());
                ProductHandlebarDto productHandlebarDto = productHandlebarMapper.toProductHandlebarDto(p.getProductHandlebar());
                ProductMaterialDto productMaterialDto = productMaterialMapper.toProductMaterialDto(p.getProductMaterial());
                List<ProductImageDto> productImageDtoList = productImageMapper.toProductImageDtoList(p.getProductImages());

                ProductDetailDto productDetailDto = productDetailMapper.toProductDetailDto(p);

                productDetailDto.setProductColorDto(productColorDto);
                productDetailDto.setProductHandlebarDto(productHandlebarDto);
                productDetailDto.setProductMaterialDto(productMaterialDto);
                productDetailDto.setProductImageDtoList(productImageDtoList);
                productDetailDtoList.add(productDetailDto);
            }
            productResponse.setProductDetailDtoList(productDetailDtoList);
        }


        return productResponse;
    }
}
