package com.fanci.Hyperion_be.controller;

import com.cloudinary.Api;
import com.fanci.Hyperion_be.dto.request.CreateNewProductHandlebarRequest;
import com.fanci.Hyperion_be.dto.request.UpdateProductHandlebarRequest;
import com.fanci.Hyperion_be.dto.response.ApiResponse;
import com.fanci.Hyperion_be.dto.response.ProductHandlebarResponse;
import com.fanci.Hyperion_be.service.ProductHandlebarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("handlebar")
public class ProductHandlebarController {
    private final ProductHandlebarService productHandlebarService;

    @GetMapping
    public ApiResponse<List<ProductHandlebarResponse>> findAllProductHandlebar(){
        return ApiResponse.<List<ProductHandlebarResponse>>builder()
                .result(productHandlebarService.findAllProductHandlebar())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductHandlebarResponse> findProductHandlebarById(@PathVariable Long id){
        return ApiResponse.<ProductHandlebarResponse>builder()
                .result(productHandlebarService.findProductHandlebarById(id))
                .build();
    }
    @PostMapping
    public ApiResponse<ProductHandlebarResponse> addNewProductHandlebar(CreateNewProductHandlebarRequest request){
        return ApiResponse.<ProductHandlebarResponse>builder()
                .result(productHandlebarService.addNewProductHandlebar(request))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<ProductHandlebarResponse> updateProductHandlebarById(@PathVariable Long id, UpdateProductHandlebarRequest request){
        return ApiResponse.<ProductHandlebarResponse>builder()
                .result(productHandlebarService.updateProductHandlebarById(request,id))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<?> deleteProductHandlebarById(@PathVariable Long id){
        productHandlebarService.deleteProductHandlebarById(id);
        return ApiResponse.builder().build();
    }
}
