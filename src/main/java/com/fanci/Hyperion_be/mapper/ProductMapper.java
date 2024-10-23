package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.ProductDto;
import com.fanci.Hyperion_be.dto.request.CreateNewProductRequest;
import com.fanci.Hyperion_be.dto.response.ProductResponse;
import com.fanci.Hyperion_be.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toProductResponse(Product product);

    Product toProduct(CreateNewProductRequest request);

    ProductDto toProductDto(Product product);
}
