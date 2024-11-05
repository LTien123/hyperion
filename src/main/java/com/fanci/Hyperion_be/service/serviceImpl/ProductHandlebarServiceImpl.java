package com.fanci.Hyperion_be.service.serviceImpl;

import com.fanci.Hyperion_be.dto.request.CreateNewProductHandlebarRequest;
import com.fanci.Hyperion_be.dto.request.UpdateProductHandlebarRequest;
import com.fanci.Hyperion_be.dto.response.ProductHandlebarResponse;
import com.fanci.Hyperion_be.entity.ProductHandlebar;
import com.fanci.Hyperion_be.exception.AppException;
import com.fanci.Hyperion_be.exception.ErrorCode;
import com.fanci.Hyperion_be.mapper.ProductHandlebarMapper;
import com.fanci.Hyperion_be.repository.ProductHandlebarRepository;
import com.fanci.Hyperion_be.service.ProductHandlebarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductHandlebarServiceImpl implements ProductHandlebarService {

    private final ProductHandlebarRepository productHandlebarRepository;

    private final ProductHandlebarMapper productHandlebarMapper;

    @Override
    public List<ProductHandlebarResponse> findAllProductHandlebar() {
        return productHandlebarRepository.findAll().stream().map(this::toProductHandlebarResponse).toList();
    }

    @Override
    public ProductHandlebarResponse findProductHandlebarById(Long id){
        return toProductHandlebarResponse(productHandlebarRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_HANDLEBAR_ID_NOT_FOUND)));
    }

    @Override
    public ProductHandlebarResponse addNewProductHandlebar(CreateNewProductHandlebarRequest request) {
        var productHandlebar = productHandlebarMapper.toProductHandleBar(request);
        return toProductHandlebarResponse(productHandlebarRepository.save(productHandlebar));
    }

    @Override
    public ProductHandlebarResponse updateProductHandlebarById(UpdateProductHandlebarRequest request, Long id) {
        var productHandlebar = productHandlebarRepository.findByProductHandlebarId(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_HANDLEBAR_ID_NOT_FOUND));
        productHandlebarMapper.updateProductHandlebarByRequest(request, productHandlebar);
        return toProductHandlebarResponse(productHandlebarRepository.save(productHandlebar));
    }

    @Override
    public void deleteProductHandlebarById(Long id) {
        var productHandlebar = productHandlebarRepository.findByProductHandlebarId(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_HANDLEBAR_ID_NOT_FOUND));
        productHandlebarRepository.delete(productHandlebar);
    }


    private ProductHandlebarResponse toProductHandlebarResponse(ProductHandlebar productHandlebar) {
        return productHandlebarMapper.toProductHandlebarResponse(productHandlebar);
    }


}
