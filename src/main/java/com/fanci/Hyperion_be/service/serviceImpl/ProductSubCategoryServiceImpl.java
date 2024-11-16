package com.fanci.Hyperion_be.service.serviceImpl;

import com.fanci.Hyperion_be.dto.request.CreateNewProductSubCategoryRequest;
import com.fanci.Hyperion_be.dto.request.UpdateSubCategoryRequest;
import com.fanci.Hyperion_be.dto.response.ProductSubCategoryResponse;
import com.fanci.Hyperion_be.entity.ProductSubCategory;
import com.fanci.Hyperion_be.exception.AppException;
import com.fanci.Hyperion_be.exception.ErrorCode;
import com.fanci.Hyperion_be.mapper.ProductCategoryMapper;
import com.fanci.Hyperion_be.mapper.ProductSubCategoryMapper;
import com.fanci.Hyperion_be.repository.ProductCategoryRepository;
import com.fanci.Hyperion_be.repository.ProductSubCategoryRepository;
import com.fanci.Hyperion_be.service.ProductSubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService {
    private final ProductSubCategoryRepository productSubCategoryRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductSubCategoryMapper productSubCategoryMapper;
    private final ProductCategoryMapper productCategoryMapper;
    private final UploadService uploadService;

    @Override
    public Page<ProductSubCategoryResponse> findProductSubCategoriesByProductCategoryIdWithPagination(Long productCategoryId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productSubCategoryRepository.findAllProductSubCategoryByProductCategoryId(productCategoryId, pageable).map(this::toProductSubCategoryResponse);
    }
    @Override
    public ProductSubCategoryResponse findProductSubCategoryById(Long id){
        var productSubCategory = productSubCategoryRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_SUB_CATEGORY_ID_NOT_FOUND));
        return toProductSubCategoryResponse(productSubCategory);
    }

    @Override
    public List<ProductSubCategoryResponse> findProductSubCategoryByProductCategoryName(String categoryName) {
        return productSubCategoryRepository.findByCategoryName(categoryName).stream().map(this::toProductSubCategoryResponse).toList();

    }

    private ProductSubCategoryResponse toProductSubCategoryResponse(ProductSubCategory productSubCategory) {
        ProductSubCategoryResponse categoryResponse = productSubCategoryMapper.toSubCategoryResponse(productSubCategory);
        categoryResponse.setProductCategoryDto(productCategoryMapper.toProductCategoryDto(productSubCategory.getProductCategory()));
        return categoryResponse;
    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN','SALE')")
    public ProductSubCategoryResponse addNewProductSubCategory(CreateNewProductSubCategoryRequest request) throws IOException {
        ProductSubCategory productSubCategory = productSubCategoryMapper.toSubcategory(request);
        var category = productCategoryRepository.findById(request.getProductCategoryId()).orElseThrow(() -> new AppException(ErrorCode.CATEGORY_ID_NOT_FOUND));
        productSubCategory.setProductCategory(category);
        productSubCategory.setIsActive(true);
        uploadService.uploadThumbnail(productSubCategory, request.getThumbnail());
        return this.toProductSubCategoryResponse(productSubCategoryRepository.save(productSubCategory));
    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR','SALE')")
    public ProductSubCategoryResponse updateProductSubCategoryById(UpdateSubCategoryRequest request, Long id) throws IOException {
        ProductSubCategory productSubCategory = productSubCategoryRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_SUB_CATEGORY_ID_NOT_FOUND));
        productSubCategoryMapper.updateProductSubCategoryByRequest(request, productSubCategory);

        if (request.getThumbnail() != null) {
            uploadService.deleteThumbnail(productSubCategory);
            uploadService.uploadThumbnail(productSubCategory, request.getThumbnail());
        }

        return toProductSubCategoryResponse(productSubCategoryRepository.save(productSubCategory));
    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR','SALE')")
    public void deleteProductSubCategoryById(Long id) {
        ProductSubCategory productSubCategory = productSubCategoryRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_SUB_CATEGORY_ID_NOT_FOUND));
        productSubCategory.setIsActive(false);
        productSubCategoryRepository.save(productSubCategory);
    }


}
