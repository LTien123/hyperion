package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.ProductHandlebarDto;
import com.fanci.Hyperion_be.dto.request.CreateNewProductHandlebarRequest;
import com.fanci.Hyperion_be.dto.request.UpdateBlogRequest;
import com.fanci.Hyperion_be.dto.request.UpdateProductHandlebarRequest;
import com.fanci.Hyperion_be.dto.response.ProductHandlebarResponse;
import com.fanci.Hyperion_be.entity.Blog;
import com.fanci.Hyperion_be.entity.ProductHandlebar;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductHandlebarMapper {
    List<ProductHandlebarDto> toProductHandlebarDtoList(List<ProductHandlebar> productHandlebar);

    ProductHandlebarDto toProductHandlebarDto(ProductHandlebar productHandlebar);

    ProductHandlebarResponse toProductHandlebarResponse(ProductHandlebar productHandlebar);

    ProductHandlebar toProductHandleBar(CreateNewProductHandlebarRequest request);

    void updateProductHandlebarByRequest(UpdateProductHandlebarRequest request, @MappingTarget ProductHandlebar productHandlebar);

}
