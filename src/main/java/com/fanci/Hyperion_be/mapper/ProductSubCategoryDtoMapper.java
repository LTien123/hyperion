package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.ProductSubCategoryDto;
import com.fanci.Hyperion_be.entity.ProductSubCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductSubCategoryDtoMapper {
    ProductSubCategoryDto toProductSubCategoryDto(ProductSubCategory productSubCategory);
}
