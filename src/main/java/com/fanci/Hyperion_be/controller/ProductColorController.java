package com.fanci.Hyperion_be.controller;

import com.fanci.Hyperion_be.dto.request.CreateNewProductColorRequest;
import com.fanci.Hyperion_be.dto.response.ApiResponse;
import com.fanci.Hyperion_be.dto.response.ProductColorResponse;
import com.fanci.Hyperion_be.service.ProductColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("color")
@RequiredArgsConstructor
public class ProductColorController {
    private final ProductColorService productColorService;

    @GetMapping()
    public ApiResponse<List<ProductColorResponse>> findALlProductColors(){
        return ApiResponse.<List<ProductColorResponse>>builder()
                .result(productColorService.getAllColors())
                .build();
    }

    @PostMapping
    public ApiResponse<ProductColorResponse> addNewProductColor(@RequestBody CreateNewProductColorRequest request){
        return ApiResponse.<ProductColorResponse>builder()
                .result(productColorService.addNewColor(request))
                .build();
    }
}
