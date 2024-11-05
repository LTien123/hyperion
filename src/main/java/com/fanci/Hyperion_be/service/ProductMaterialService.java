package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.request.CreateNewProductMaterialRequest;
import com.fanci.Hyperion_be.dto.request.UpdateProductMaterialRequest;
import com.fanci.Hyperion_be.dto.response.ProductMaterialResponse;

import java.util.List;

public interface ProductMaterialService {
    List<ProductMaterialResponse> findAllProductMaterials();

    ProductMaterialResponse findProductMaterialById(Long id);

    ProductMaterialResponse addNewProductMaterial(CreateNewProductMaterialRequest request);

    ProductMaterialResponse updateProductMaterialById(UpdateProductMaterialRequest request, Long id);

    void deleteProductMaterialById(Long id);
}
