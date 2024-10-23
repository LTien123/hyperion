package com.fanci.Hyperion_be.dto.response;

import com.fanci.Hyperion_be.dto.ProductCategoryDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSubCategoryResponse {
    private Long id;
    private String name;
    private String thumbnailUrl;
    private String thumbnailPublicId;
    private boolean isActive;
    private ProductCategoryDto productCategoryDto;
    private String description;
}
