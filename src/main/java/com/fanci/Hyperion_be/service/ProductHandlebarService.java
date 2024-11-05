package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.CreateNewProductHandlebarRequest;
import com.fanci.Hyperion_be.dto.request.UpdateProductHandlebarRequest;
import com.fanci.Hyperion_be.dto.response.ProductHandlebarResponse;

import java.util.List;

public interface ProductHandlebarService {
    List<ProductHandlebarResponse> findAllProductHandlebar();

    ProductHandlebarResponse findProductHandlebarById(Long id);

    ProductHandlebarResponse addNewProductHandlebar(CreateNewProductHandlebarRequest request);

    ProductHandlebarResponse updateProductHandlebarById(UpdateProductHandlebarRequest request, Long id);

    void deleteProductHandlebarById(Long id);
}
