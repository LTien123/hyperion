package com.fanci.Hyperion_be.controller.payment;

import com.fanci.Hyperion_be.dto.response.ApiResponse;
import com.fanci.Hyperion_be.entity.Paypal;
import com.fanci.Hyperion_be.service.IPaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PaypalController {

    private final IPaypalService paypalService;

    @PostMapping("/payment/create")
    public ApiResponse<String> createPayment(@RequestParam Double total,
                                             @RequestParam String currency,
                                             @RequestParam String method,
                                             @RequestParam String intent,
                                             @RequestParam String description,
                                             @RequestParam String cancelUrl,
                                             @RequestParam String successUrl) {
        try {
            Paypal paypal = new Paypal(total, currency, method, intent, description, cancelUrl, successUrl);
            Payment payment = paypalService.createPayment(paypal);

            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return ApiResponse.<String>builder().result("redirect:" + link.getHref()).build();
                }
            }

        } catch (PayPalRESTException ex) {
            log.error(ex.getMessage());
        }

        return ApiResponse.<String>builder().result("redirect:/payment/error").build();
    }

    @GetMapping("/payment/execute")
    public ApiResponse<Payment> executePayment(@RequestParam String paymentId,
                                 @RequestParam String payerId) {
        try {
            return ApiResponse.<Payment>builder().result(
                    paypalService.executePayment(paymentId, payerId)
            ).build();
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
