package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.CreateNewProductSubCategoryRequest;
import com.fanci.Hyperion_be.dto.request.UpdateSubCategoryRequest;
import com.fanci.Hyperion_be.dto.response.ProductSubCategoryResponse;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface ProductSubCategoryService {



    Page<ProductSubCategoryResponse> findProductSubCategoriesByProductCategoryIdWithPagination( Long productCategoryId, int page, int size);
    ProductSubCategoryResponse addNewProductSubCategory(CreateNewProductSubCategoryRequest request) throws IOException;

    ProductSubCategoryResponse findProductSubCategoryById(Long id);

    List<ProductSubCategoryResponse> findProductSubCategoryByProductCategoryName(String name);

    ProductSubCategoryResponse updateProductSubCategoryById(UpdateSubCategoryRequest request, Long id) throws IOException;

    void deleteProductSubCategoryById(Long id);
}
