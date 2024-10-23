package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.request.CreateNewBlogRequest;
import com.fanci.Hyperion_be.dto.request.UpdateBlogRequest;
import com.fanci.Hyperion_be.dto.response.BlogResponse;
import com.fanci.Hyperion_be.entity.Blog;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BlogMapper {
    BlogResponse toBlogResponse(Blog blog);
    Blog toBlog(CreateNewBlogRequest request);

    void updateBlogFromRequest(UpdateBlogRequest request, @MappingTarget Blog blog);
}
