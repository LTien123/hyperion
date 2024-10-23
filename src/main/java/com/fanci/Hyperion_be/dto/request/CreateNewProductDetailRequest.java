package com.fanci.Hyperion_be.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNewProductDetailRequest {
    private Integer stock;
    private Long productId;
    private Long colorId;
    private Long handlebarId;
    private Long materialId;
    private List<MultipartFile> images;

}
