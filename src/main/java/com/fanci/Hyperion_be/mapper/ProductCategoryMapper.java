package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.ProductCategoryDto;
import com.fanci.Hyperion_be.dto.request.CreateNewProductCategoryRequest;
import com.fanci.Hyperion_be.dto.response.ProductCategoryResponse;
import com.fanci.Hyperion_be.dto.response.ProductCategoryResponseSimple;
import com.fanci.Hyperion_be.entity.ProductCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {
    ProductCategoryResponseSimple toProductCategoryResponseSimple(ProductCategory productCategory);

    ProductCategoryResponse toProductCategoryResponse(ProductCategory productCategory);
    ProductCategory toProductCategory(CreateNewProductCategoryRequest request);

    ProductCategoryDto toProductCategoryDto(ProductCategory productCategory);
}
