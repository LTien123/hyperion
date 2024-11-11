package com.fanci.Hyperion_be.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderDetailResponse {
    private Long id;
    private ProductDetailResponse productDetailResponse;
    private Integer amount;

}
