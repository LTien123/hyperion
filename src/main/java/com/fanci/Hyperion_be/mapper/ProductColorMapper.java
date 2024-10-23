package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.ProductColorDto;
import com.fanci.Hyperion_be.dto.request.CreateNewProductColorRequest;
import com.fanci.Hyperion_be.dto.response.ProductColorResponse;
import com.fanci.Hyperion_be.entity.ProductColor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductColorMapper {
    ProductColorResponse toProductColorResponse(ProductColor productColor);
    ProductColor toProductColor(CreateNewProductColorRequest request);

    List<ProductColorDto> toProductColorDtoList(List<ProductColor> productColor);

    ProductColorDto toProductColorDto(ProductColor productColor);
}
