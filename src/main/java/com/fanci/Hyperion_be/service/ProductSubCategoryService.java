package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.CreateNewProductSubCategoryRequest;
import com.fanci.Hyperion_be.dto.response.ProductSubCategoryResponse;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface ProductSubCategoryService {



    Page<ProductSubCategoryResponse> findProductSubCategoriesByProductCategoryIdWithPagination( Long productCategoryId, int page, int size);
    ProductSubCategoryResponse addNewProductSubCategory(CreateNewProductSubCategoryRequest request) throws IOException;

    List<ProductSubCategoryResponse> findProductSubCategoryByProductCategoryName(String name);
}
