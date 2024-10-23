package com.fanci.Hyperion_be.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductImageDto {
    private Long id;
    private String url;
    private String publicId;
}
