package com.fanci.Hyperion_be.controller;

import com.fanci.Hyperion_be.dto.request.CreateNewProductDetailRequest;
import com.fanci.Hyperion_be.dto.request.CreateNewProductRequest;
import com.fanci.Hyperion_be.dto.response.ApiResponse;
import com.fanci.Hyperion_be.dto.response.ProductDetailResponse;
import com.fanci.Hyperion_be.service.ProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("product-detail")
@RequiredArgsConstructor
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    @GetMapping
    public ApiResponse<List<ProductDetailResponse>> findAllProductDetailByProductName(@RequestParam String productName){
        return ApiResponse.<List<ProductDetailResponse>>builder()
                .result(productDetailService.findAllProductDetailByProductName(productName))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductDetailResponse> findProductDetailById(@PathVariable Long id){
        return ApiResponse.<ProductDetailResponse>builder()
                .result(productDetailService.findProductDetailById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<ProductDetailResponse> addNewProductDetailByProductName(@ModelAttribute CreateNewProductDetailRequest request) throws IOException {
        return ApiResponse.<ProductDetailResponse>builder()
                .result(productDetailService.addNewProductDetailByProductName(request))
                .build();
    }




}
