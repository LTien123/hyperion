package com.fanci.Hyperion_be.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNewProductRequest {
    private String name;
    private Double price;
    private Float weight;
    private MultipartFile thumbnail;
    private String description;
    private Long productSubCategoryId;

}
