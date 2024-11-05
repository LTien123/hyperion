package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.CreateNewProductDetailRequest;
import com.fanci.Hyperion_be.dto.request.UpdateProductDetailRequest;
import com.fanci.Hyperion_be.dto.response.ProductDetailResponse;
import com.fanci.Hyperion_be.entity.ProductDetail;

import java.io.IOException;
import java.util.List;

public interface ProductDetailService {
    List<ProductDetailResponse> findAllProductDetailByProductName(String productName);

    ProductDetailResponse addNewProductDetailByProductName(CreateNewProductDetailRequest request) throws IOException;

    ProductDetailResponse updateProductDetailById(Long id, UpdateProductDetailRequest request) throws IOException;

    ProductDetailResponse findProductDetailById(Long id);

    void deleteProductDetailById(Long id);
}
