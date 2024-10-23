package com.fanci.Hyperion_be.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ProductColorDto {
    private Long id;
    private String color;

}
