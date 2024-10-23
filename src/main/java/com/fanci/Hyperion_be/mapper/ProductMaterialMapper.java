package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.ProductMaterialDto;
import com.fanci.Hyperion_be.entity.ProductMaterial;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMaterialMapper {
   ProductMaterialDto toProductMaterialDto(ProductMaterial productMaterials);
}
