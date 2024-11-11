package com.fanci.Hyperion_be.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationResponse {
    private Long id;
    private LocalDateTime createdAt;
    private String orderStatus;
    private String notificationStatus;
    private Long orderId;
}
