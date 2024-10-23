package com.fanci.Hyperion_be.controller;

import com.fanci.Hyperion_be.dto.request.CreateNewBlogCategoryRequest;
import com.fanci.Hyperion_be.dto.response.ApiResponse;
import com.fanci.Hyperion_be.dto.response.BlogCategoryResponse;
import com.fanci.Hyperion_be.service.BlogCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("blog-categories")
public class BlogCategoryController {
    private final BlogCategoryService blogCategoryService;

    @GetMapping
    public ApiResponse<Set<BlogCategoryResponse>> findAllBlogCategories(){
        return ApiResponse.<Set<BlogCategoryResponse>>builder()
                .result(blogCategoryService.findAllBlogCategories())
                .build();
    }

    @PostMapping
    public ApiResponse<BlogCategoryResponse> addNewBlogCategory(@RequestBody CreateNewBlogCategoryRequest request){
        return ApiResponse.<BlogCategoryResponse>builder()
                .result(blogCategoryService.addNewBlogCategory(request))
                .build();
    }

}
