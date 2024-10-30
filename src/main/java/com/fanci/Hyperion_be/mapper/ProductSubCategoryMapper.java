package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.ProductSubCategoryDto;
import com.fanci.Hyperion_be.dto.request.CreateNewProductSubCategoryRequest;
import com.fanci.Hyperion_be.dto.response.ProductSubCategoryResponse;
import com.fanci.Hyperion_be.entity.ProductSubCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface ProductSubCategoryMapper {
    ProductSubCategory toSubcategory(CreateNewProductSubCategoryRequest request);

    ProductSubCategoryResponse toSubCategoryResponse(ProductSubCategory productSubCategory);

    ProductSubCategoryDto toProductSubCategoryDto(ProductSubCategory productSubCategory);
}
