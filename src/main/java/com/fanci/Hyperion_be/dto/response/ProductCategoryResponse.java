package com.fanci.Hyperion_be.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

 public class ProductCategoryResponse {
    private Long id;
    private String name;
    private boolean isActive;
}
