package com.fanci.Hyperion_be.dto.response;

import com.fanci.Hyperion_be.dto.ProductColorDto;
import com.fanci.Hyperion_be.dto.ProductDto;
import com.fanci.Hyperion_be.dto.ProductHandlebarDto;
import com.fanci.Hyperion_be.dto.ProductMaterialDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailResponse {
    private Long id;
    private Integer stock;
    private boolean isActive;
    private ProductDto productDto;
    private ProductColorDto productColorDto;
    private ProductHandlebarDto productHandlebarDto;
    private ProductMaterialDto productMaterialDto;
    private List<ProductImageResponse> productImageResponseList;


}
