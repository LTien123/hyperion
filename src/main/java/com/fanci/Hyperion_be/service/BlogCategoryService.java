package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.CreateNewBlogCategoryRequest;
import com.fanci.Hyperion_be.dto.response.BlogCategoryResponse;

import java.util.Set;

public interface BlogCategoryService {
    Set<BlogCategoryResponse> findAllBlogCategories();

    BlogCategoryResponse addNewBlogCategory(CreateNewBlogCategoryRequest request);

}
