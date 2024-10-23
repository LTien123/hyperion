package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.CreateNewProductCategoryRequest;
import com.fanci.Hyperion_be.dto.response.ProductCategoryResponse;
import org.springframework.data.domain.Page;

public interface ProductCategoryService {
    Page<ProductCategoryResponse> findAllProductCategoriesWithPagination(int page, int size);

    ProductCategoryResponse addNewProductCategory(CreateNewProductCategoryRequest request);

}
