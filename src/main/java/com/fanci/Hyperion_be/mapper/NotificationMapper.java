package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.response.NotificationResponse;
import com.fanci.Hyperion_be.entity.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationResponse toNotificationResponse(Notification notification);
}
