package com.fanci.Hyperion_be.service;

import com.fanci.Hyperion_be.dto.response.PaymentMethodResponse;

import java.util.List;

public interface PaymentMethodService {
    List<PaymentMethodResponse> findAllPaymentMethod();
}
