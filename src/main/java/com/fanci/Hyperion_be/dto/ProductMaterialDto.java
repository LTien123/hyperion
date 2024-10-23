package com.fanci.Hyperion_be.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ProductMaterialDto {
    private Long id;
    private String material;
}
