package com.fanci.Hyperion_be.service.serviceImpl;

import com.fanci.Hyperion_be.dto.response.PaymentMethodResponse;
import com.fanci.Hyperion_be.mapper.PaymentMethodMapper;
import com.fanci.Hyperion_be.repository.PaymentMethodRepository;
import com.fanci.Hyperion_be.service.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentMethodMapper paymentMethodMapper;

    @Override
    public List<PaymentMethodResponse> findAllPaymentMethod(){
        return paymentMethodRepository.findAll().stream().map(paymentMethodMapper::toPaymentMethodResponse).toList();
    }
}
