package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.ProductImageDto;
import com.fanci.Hyperion_be.dto.response.ProductImageResponse;
import com.fanci.Hyperion_be.entity.ProductImage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {
    ProductImageResponse toProductImageResponse(ProductImage productImage);
    List<ProductImageResponse> toProductImageResponseList(List<ProductImage> productImageList);
    List<ProductImageDto> toProductImageDtoList(List<ProductImage> productImageList);
}
