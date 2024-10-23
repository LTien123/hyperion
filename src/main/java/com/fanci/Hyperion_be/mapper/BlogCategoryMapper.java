package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.request.CreateNewBlogCategoryRequest;
import com.fanci.Hyperion_be.dto.response.BlogCategoryResponse;
import com.fanci.Hyperion_be.entity.BlogCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogCategoryMapper {
    BlogCategoryResponse toBlogCategoryResponse(BlogCategory blogCategory);
    BlogCategory toBlogCategory(CreateNewBlogCategoryRequest request);
}
