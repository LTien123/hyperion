package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.ProductDto;
import com.fanci.Hyperion_be.dto.request.CreateNewProductRequest;
import com.fanci.Hyperion_be.dto.request.UpdateProductRequest;
import com.fanci.Hyperion_be.dto.request.UpdateUserRequest;
import com.fanci.Hyperion_be.dto.response.ProductResponse;
import com.fanci.Hyperion_be.entity.Product;
import com.fanci.Hyperion_be.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toProductResponse(Product product);

    Product toProduct(CreateNewProductRequest request);

    ProductDto toProductDto(Product product);

    void updateProduct(UpdateProductRequest request, @MappingTarget Product product);


}
