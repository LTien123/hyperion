package com.fanci.Hyperion_be.mapper;

import com.fanci.Hyperion_be.dto.response.PaymentMethodResponse;
import com.fanci.Hyperion_be.entity.PaymentMethod;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {
    PaymentMethodResponse toPaymentMethodResponse(PaymentMethod paymentMethod);
}
