package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.CreateNewProductCategoryRequest;
import com.fanci.Hyperion_be.dto.response.ProductCategoryResponse;
import com.fanci.Hyperion_be.dto.response.ProductCategoryResponseSimple;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductCategoryService {
    Page<ProductCategoryResponseSimple> findAllProductCategoriesWithPagination(int page, int size);

    List<ProductCategoryResponse> findAllProductCategories();

    ProductCategoryResponseSimple addNewProductCategory(CreateNewProductCategoryRequest request);

}
