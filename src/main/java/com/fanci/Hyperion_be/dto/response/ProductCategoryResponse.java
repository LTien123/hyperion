package com.fanci.Hyperion_be.dto.response;

import com.fanci.Hyperion_be.dto.ProductSubCategoryDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategoryResponse {
    private Long id;
    private String name;
    private boolean isActive;
    private List<ProductSubCategoryDto> productSubCategoryDtoList;

}