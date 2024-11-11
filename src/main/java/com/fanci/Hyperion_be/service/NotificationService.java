package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.response.NotificationResponse;
import org.springframework.data.domain.Page;

public interface NotificationService {

    void setReadNotificationById(Long id);


    Page<NotificationResponse> findAllNotificationByUserId(Long userId, int page, int size);
}
