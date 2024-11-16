package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.CreateNewBlogRequest;
import com.fanci.Hyperion_be.dto.request.UpdateBlogRequest;
import com.fanci.Hyperion_be.dto.response.BlogResponse;
import org.springframework.data.domain.Page;

import java.io.IOException;

public interface BlogService {

    Page<BlogResponse> findAllBlogsWithPaginationByBlogCategoryId(Long blockCategoryId, int page, int size);

    BlogResponse findBlogById(Long id);

    Page<BlogResponse> findAllCarouselBlog(int page, int size);

    BlogResponse addNewBlog(CreateNewBlogRequest request) throws IOException;

    BlogResponse changeCarousel(Long id);

    Page<BlogResponse> findAllBlogs(int page, int size);

    BlogResponse updateBlogById(Long blogId, UpdateBlogRequest request) throws IOException;

    void deleteBlogById(Long blogId);
}
