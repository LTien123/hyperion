package com.fanci.Hyperion_be.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateProductRequest {
    private String name;
    private Double price;
    private Float weight;
    private MultipartFile thumbnail;
    private String description;
}
