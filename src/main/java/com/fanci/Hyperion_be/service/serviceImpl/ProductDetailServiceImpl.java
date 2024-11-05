package com.fanci.Hyperion_be.service.serviceImpl;

import com.fanci.Hyperion_be.dto.request.CreateNewProductDetailRequest;
import com.fanci.Hyperion_be.dto.request.UpdateProductDetailRequest;
import com.fanci.Hyperion_be.dto.response.ProductDetailResponse;
import com.fanci.Hyperion_be.dto.response.ProductImageResponse;
import com.fanci.Hyperion_be.entity.*;
import com.fanci.Hyperion_be.exception.AppException;
import com.fanci.Hyperion_be.exception.ErrorCode;
import com.fanci.Hyperion_be.mapper.*;
import com.fanci.Hyperion_be.repository.*;
import com.fanci.Hyperion_be.service.ProductDetailService;
import com.fanci.Hyperion_be.service.ProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductDetailServiceImpl implements ProductDetailService {
    private final ProductDetailRepository productDetailRepository;
    private final ProductRepository productRepository;
    private final ProductHandlebarRepository productHandlebarRepository;
    private final ProductMaterialRepository productMaterialRepository;
    private final ProductColorRepository productColorRepository;
    private final ProductImageService productImageService;


    private final ProductDetailMapper productDetailMapper;
    private final ProductMapper productMapper;
    private final ProductColorMapper productColorMapper;
    private final ProductHandlebarMapper productHandlebarMapper;
    private final ProductMaterialMapper productMaterialMapper;

    private final ProductImageMapper productImageMapper;

    @Override
    public List<ProductDetailResponse> findAllProductDetailByProductName(String productName) {
        return productDetailRepository.findProductDetailByProductName(productName).stream().map(this::toProductDetailResponse).toList();
    }

    @Override
    public ProductDetailResponse addNewProductDetailByProductName(CreateNewProductDetailRequest request) throws IOException {
        //create product detail
        ProductDetail productDetail = productDetailMapper.toProductDetail(request);
        //add product
        Product product = productRepository.findProductByProductId(request.getProductId()).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_ID_NOT_FOUND));
        productDetail.setProduct(product);

        //add handlebar

        if (request.getHandlebarId() != null) {
            var productHandlebar = productHandlebarRepository.findByProductHandlebarId(request.getHandlebarId()).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_HANDLEBAR_ID_NOT_FOUND));
            productDetail.setProductHandlebar(productHandlebar);
        }


        //add material

        if (request.getMaterialId() != null) {
            ProductMaterial productMaterial = productMaterialRepository.findByProductMaterialId(request.getMaterialId()).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_MATERIAL_ID_NOT_FOUND));
            productDetail.setProductMaterial(productMaterial);
        }

        //add color
        ProductColor productColor = productColorRepository.findByProductColorId(request.getColorId()).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_COLOR_ID_NOT_FOUND));
        productDetail.setProductColor(productColor);

        //set active
        productDetail.setActive(true);

        // if material, color, handlebar are same, thr error that product already existed
        productDetailRepository.findProductDetailByProductName(product.getName()).forEach((res) -> {
            if (res.getProductMaterial() == productDetail.getProductMaterial() && res.getProductColor() == productDetail.getProductColor() && res.getProductHandlebar() == productDetail.getProductHandlebar()) {
                throw new AppException(ErrorCode.PRODUCT_DETAIL_DUPLICATED);
            }
        });

        //save product detail to database, change to product detail response
        var newProductDetail = productDetailRepository.save(productDetail);
        var productDetailResponse = this.toProductDetailResponse(newProductDetail);


        //add product image response to product detail response
        List<ProductImageResponse> productImageResponseList = productImageService.uploadProductImagesToCloudinary(newProductDetail, request.getImages());
        productDetailResponse.setProductImageResponseList(productImageResponseList);

        return productDetailResponse;
    }

    @Override
    public ProductDetailResponse updateProductDetailById(Long id, UpdateProductDetailRequest request) throws IOException {
        var productDetail = productDetailRepository.findProductDetailById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_DETAIL_ID_NOT_FOUND));
        productDetailMapper.updateProductDetail(request,productDetail);

        //add handlebar

        if (request.getHandlebarId() != null) {
            var productHandlebar = productHandlebarRepository.findByProductHandlebarId(request.getHandlebarId()).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_HANDLEBAR_ID_NOT_FOUND));
            productDetail.setProductHandlebar(productHandlebar);
        }

        //add material
        if (request.getMaterialId() != null) {
            ProductMaterial productMaterial = productMaterialRepository.findByProductMaterialId(request.getMaterialId()).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_MATERIAL_ID_NOT_FOUND));
            productDetail.setProductMaterial(productMaterial);
        }

        //add color
        ProductColor productColor = productColorRepository.findByProductColorId(request.getColorId()).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_COLOR_ID_NOT_FOUND));
        productDetail.setProductColor(productColor);

        // if material, color, handlebar are same, thr error that product already existed
        productDetailRepository.findProductDetailByProductName(productDetail.getProduct().getName()).forEach((res) -> {
            if (res != productDetail && res.getProductMaterial() == productDetail.getProductMaterial() && res.getProductColor() == productDetail.getProductColor() && res.getProductHandlebar() == productDetail.getProductHandlebar()) {
                throw new AppException(ErrorCode.PRODUCT_DETAIL_DUPLICATED);
            }
        });
        //save product detail to db

        var productDetailResponse = toProductDetailResponse( productDetailRepository.save(productDetail));
        //add product image response to product detail response
        if(request.getImages() != null){
            List<ProductImageResponse> productImageResponseList = productImageService.uploadProductImagesToCloudinary(productDetail, request.getImages());
           productImageResponseList.forEach(productImageResponse -> productDetailResponse.getProductImageResponseList().add(productImageResponse));
        }

        return productDetailResponse;
    }

    @Override
    public ProductDetailResponse findProductDetailById(Long id) {
        var productDetail = productDetailRepository.findProductDetailById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_DETAIL_ID_NOT_FOUND));
        return toProductDetailResponse(productDetail);
    }

    @Override
    public void deleteProductDetailById(Long id) {
        var productDetail = productDetailRepository.findProductDetailById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_DETAIL_ID_NOT_FOUND));
        productDetail.setActive(false);
        productDetailRepository.save(productDetail);
    }

    public ProductDetailResponse toProductDetailResponse(ProductDetail productDetail) {
        var productDetailResponse = productDetailMapper.toProductDetailResponse(productDetail);
        productDetailResponse.setProductDto(productMapper.toProductDto(productDetail.getProduct()));
        productDetailResponse.setProductColorDto(productColorMapper.toProductColorDto(productDetail.getProductColor()));
        productDetailResponse.setProductHandlebarDto(productHandlebarMapper.toProductHandlebarDto(productDetail.getProductHandlebar()));
        productDetailResponse.setProductMaterialDto(productMaterialMapper.toProductMaterialDto(productDetail.getProductMaterial()));
        productDetailResponse.setProductImageResponseList(productImageMapper.toProductImageResponseList(productDetail.getProductImages()));
        if (productDetailResponse.getProductImageResponseList() != null) {
            productDetailResponse.getProductImageResponseList().forEach(productImageResponse -> productImageResponse.setProductDetailId(productDetailResponse.getId()));
        }
        return productDetailResponse;
    }


}
