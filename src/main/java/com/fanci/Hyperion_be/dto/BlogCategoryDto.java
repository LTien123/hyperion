package com.fanci.Hyperion_be.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogCategoryDto {
    private Long id;
    private String name;
}
