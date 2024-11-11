package com.fanci.Hyperion_be.controller;

import com.fanci.Hyperion_be.dto.response.ApiResponse;
import com.fanci.Hyperion_be.dto.response.NotificationResponse;
import com.fanci.Hyperion_be.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("notification")
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping("set-to-read/{id}")
    public ApiResponse<?> setReadNotification(@PathVariable Long id){
        notificationService.setReadNotificationById(id);
        return ApiResponse.builder().build();
    }

    @GetMapping("/{userId}")
    public ApiResponse<Page<NotificationResponse>> findALlNotificationsByUserId(@PathVariable Long userId, @RequestParam int page, @RequestParam int size){
        return ApiResponse.<Page<NotificationResponse>>builder()
                .result(notificationService.findAllNotificationByUserId(userId,page,size))
                .build();
    }


}
