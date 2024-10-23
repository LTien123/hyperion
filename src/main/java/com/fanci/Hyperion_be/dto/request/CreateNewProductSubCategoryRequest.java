package com.fanci.Hyperion_be.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNewProductSubCategoryRequest {
    private String name;
    private Long productCategoryId;
    private MultipartFile thumbnail;
    private String description;
}
