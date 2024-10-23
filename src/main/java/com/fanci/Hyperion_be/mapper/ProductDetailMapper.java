package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.ProductDetailDto;
import com.fanci.Hyperion_be.dto.request.CreateNewProductDetailRequest;
import com.fanci.Hyperion_be.dto.response.ProductDetailResponse;
import com.fanci.Hyperion_be.entity.ProductDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDetailMapper {
    ProductDetailResponse toProductDetailResponse(ProductDetail productDetail);
    ProductDetail toProductDetail(CreateNewProductDetailRequest request);

    ProductDetailDto toProductDetailDto(ProductDetail productDetail);

}
