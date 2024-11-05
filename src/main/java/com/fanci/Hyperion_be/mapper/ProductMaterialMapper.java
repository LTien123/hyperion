package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.ProductMaterialDto;
import com.fanci.Hyperion_be.dto.request.CreateNewProductMaterialRequest;
import com.fanci.Hyperion_be.dto.request.UpdateProductMaterialRequest;
import com.fanci.Hyperion_be.dto.response.ProductMaterialResponse;
import com.fanci.Hyperion_be.entity.ProductMaterial;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMaterialMapper {
   ProductMaterialDto toProductMaterialDto(ProductMaterial productMaterials);

   ProductMaterialResponse toProductMaterialResponse(ProductMaterial productMaterial);

   ProductMaterial toProductMaterial(CreateNewProductMaterialRequest request);

   void updateProductMaterialByRequest(UpdateProductMaterialRequest request, @MappingTarget ProductMaterial productMaterial);
}
