package com.fanci.Hyperion_be.service;


import com.fanci.Hyperion_be.dto.PaypalDto;
import com.fanci.Hyperion_be.entity.Paypal;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

public interface IPaypalService {
    Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;

    Payment createPayment(Paypal paypal) throws PayPalRESTException;
}
