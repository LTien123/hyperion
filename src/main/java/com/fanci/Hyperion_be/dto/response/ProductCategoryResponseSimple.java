package com.fanci.Hyperion_be.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

 public class ProductCategoryResponseSimple {
    private Long id;
    private String name;
    private boolean isActive;
}
