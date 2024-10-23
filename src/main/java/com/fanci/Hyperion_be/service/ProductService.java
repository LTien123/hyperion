package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.CreateNewProductRequest;
import com.fanci.Hyperion_be.dto.response.ProductResponse;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    Page<ProductResponse> findAllProductByProductSubCategoryName(String productSubCategoryName, int page, int size);

    ProductResponse findProductByProductName(String productName);

    ProductResponse createNewProduct(CreateNewProductRequest request) throws IOException;
}
