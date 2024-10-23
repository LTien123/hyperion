package com.fanci.Hyperion_be.controller;

import com.fanci.Hyperion_be.dto.request.CreateNewProductCategoryRequest;
import com.fanci.Hyperion_be.dto.response.ApiResponse;
import com.fanci.Hyperion_be.dto.response.ProductCategoryResponse;
import com.fanci.Hyperion_be.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("product-categories")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @GetMapping
    public ApiResponse<Page<ProductCategoryResponse>> findAllProductCategoriesWithPagination(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1000") int size){
        return ApiResponse.<Page<ProductCategoryResponse>>builder()
                .result(productCategoryService.findAllProductCategoriesWithPagination(page,size))
                .build();
    }

    @PostMapping
    public ApiResponse<ProductCategoryResponse> addNewProductCategory(@RequestBody CreateNewProductCategoryRequest request){
        return ApiResponse.<ProductCategoryResponse>builder()
                .result(productCategoryService.addNewProductCategory(request))
                .build();
    }



}
