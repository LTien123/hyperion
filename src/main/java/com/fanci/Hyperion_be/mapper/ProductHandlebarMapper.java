package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.ProductHandlebarDto;
import com.fanci.Hyperion_be.entity.ProductHandlebar;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductHandlebarMapper {
    List<ProductHandlebarDto> toProductHandlebarDtoList(List<ProductHandlebar> productHandlebar);

    ProductHandlebarDto toProductHandlebarDto(ProductHandlebar productHandlebar);

}
