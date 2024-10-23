package com.fanci.Hyperion_be.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogCategoryResponse {
    private Long id;
    private String name;
}
