package com.fanci.Hyperion_be.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderNotificationDto {
    private Long orderId;
    private String orderStatus;
}
