package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.ProductCategoryDto;
import com.fanci.Hyperion_be.entity.ProductCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCategoryDtoMapper {
    ProductCategoryDto toProductCategoryDto(ProductCategory productCategory);
}
