package com.fanci.Hyperion_be.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailDto {
    private Long id;
    private Integer stock;
    private boolean isActive;
    private ProductDto productDto;
    private ProductColorDto productColorDto;
    private ProductHandlebarDto productHandlebarDto;
    private ProductMaterialDto productMaterialDto;
    private List<ProductImageDto> productImageDtoList;

}
