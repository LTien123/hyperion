package com.fanci.Hyperion_be.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNewNotificationRequest {
    private String orderStatus;
    private String orderId;
    private Long roleId;
    private String notificationStatus;
}
