package com.fanci.Hyperion_be.dto.response;

import com.fanci.Hyperion_be.dto.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private Double price;
    private Float weight;
    private String description;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String thumbnailUrl;
    private String thumbnailPublicId;
    private ProductSubCategoryDto productSubCategoryDto;
    private ProductCategoryDto productCategoryDto;
    private List<ProductDetailDto> productDetailDtoList;





}
