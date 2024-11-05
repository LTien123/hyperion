package com.fanci.Hyperion_be.service.serviceImpl;

import com.fanci.Hyperion_be.dto.request.CreateNewProductMaterialRequest;
import com.fanci.Hyperion_be.dto.request.UpdateProductMaterialRequest;
import com.fanci.Hyperion_be.dto.response.ProductMaterialResponse;
import com.fanci.Hyperion_be.entity.ProductMaterial;
import com.fanci.Hyperion_be.exception.AppException;
import com.fanci.Hyperion_be.exception.ErrorCode;
import com.fanci.Hyperion_be.mapper.ProductMaterialMapper;
import com.fanci.Hyperion_be.repository.ProductMaterialRepository;
import com.fanci.Hyperion_be.service.ProductMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductMaterialServiceImpl implements ProductMaterialService {

    private final ProductMaterialRepository productMaterialRepository;

    private final ProductMaterialMapper productMaterialMapper;

    @Override
    public List<ProductMaterialResponse> findAllProductMaterials() {
        return productMaterialRepository.findAll().stream().map(this::toProductMaterialResponse).toList();
    }

    @Override
    public ProductMaterialResponse findProductMaterialById(Long id){
        return toProductMaterialResponse(productMaterialRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_MATERIAL_ID_NOT_FOUND)));
    }

    @Override
    public ProductMaterialResponse addNewProductMaterial(CreateNewProductMaterialRequest request) {
        var ProductMaterial = productMaterialMapper.toProductMaterial(request);
        return toProductMaterialResponse(productMaterialRepository.save(ProductMaterial));
    }

    @Override
    public ProductMaterialResponse updateProductMaterialById(UpdateProductMaterialRequest request, Long id) {
        var ProductMaterial = productMaterialRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_HANDLEBAR_ID_NOT_FOUND));
        productMaterialMapper.updateProductMaterialByRequest(request, ProductMaterial);
        return toProductMaterialResponse(productMaterialRepository.save(ProductMaterial));
    }

    @Override
    public void deleteProductMaterialById(Long id) {
        var ProductMaterial = productMaterialRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_HANDLEBAR_ID_NOT_FOUND));
        productMaterialRepository.delete(ProductMaterial);
    }
    private ProductMaterialResponse toProductMaterialResponse(ProductMaterial productMaterial) {
        return productMaterialMapper.toProductMaterialResponse(productMaterial);
    }

}
