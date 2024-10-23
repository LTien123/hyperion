package com.fanci.Hyperion_be.dto.response;

import com.fanci.Hyperion_be.dto.ProductColorDto;
import com.fanci.Hyperion_be.dto.ProductDetailDto;
import com.fanci.Hyperion_be.dto.ProductDto;
import com.fanci.Hyperion_be.dto.ProductHandlebarDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImageResponse {
    private String id;
    private String url;
    private String publicId;
    private Long productDetailId;
}
