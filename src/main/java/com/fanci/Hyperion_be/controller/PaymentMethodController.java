package com.fanci.Hyperion_be.controller;

import com.fanci.Hyperion_be.dto.response.ApiResponse;
import com.fanci.Hyperion_be.dto.response.PaymentMethodResponse;
import com.fanci.Hyperion_be.service.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("payment-method")
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

    @GetMapping()
    public ApiResponse<List<PaymentMethodResponse>> findAllPaymentMethod(){
        return ApiResponse.<List<PaymentMethodResponse>>builder()
                .result(paymentMethodService.findAllPaymentMethod())
                .build();
    }

}
