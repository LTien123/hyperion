package com.fanci.Hyperion_be.service.serviceImpl;

import com.fanci.Hyperion_be.exception.AppException;
import com.fanci.Hyperion_be.exception.ErrorCode;
import com.paypal.http.HttpResponse;
import com.paypal.orders.*;
import com.paypal.core.PayPalHttpClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;

import lombok.RequiredArgsConstructor;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaypalService {

    private final PayPalHttpClient payPalHttpClient;

    public String createOrder(Double totalAmount, Long orderId) throws IOException {
        // Tạo đơn hàng
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.checkoutPaymentIntent("CAPTURE");


        ApplicationContext applicationContext = new ApplicationContext()
                .brandName("Hyperion")
                .landingPage("BILLING")  // Chuyển trang sau khi thanh toán
                .returnUrl("http://localhost:4200/payment/"+orderId);  // Địa chỉ trả về sau khi thanh toán thành công
        orderRequest.applicationContext(applicationContext);

        // Thêm thông tin thanh toán
        PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest()
                .referenceId(orderId.toString())
                .amountWithBreakdown(new AmountWithBreakdown()
                        .currencyCode("USD")
                        .value(String.format("%.2f", totalAmount)));

        orderRequest.purchaseUnits(Collections.singletonList(purchaseUnitRequest));

        // Tạo yêu cầu gửi đi
        OrdersCreateRequest request = new OrdersCreateRequest().requestBody(orderRequest);

        // Gửi yêu cầu tới PayPal để tạo đơn hàng
        HttpResponse<Order> response = payPalHttpClient.execute(request);

        Order order = response.result();

        // Trả về đơn hàng vừa tạo
        return order.links().stream()
                .filter(link -> link.rel().equals("approve"))
                .findFirst()
                .orElseThrow(() -> new IOException("Approval link not found"))
                .href();
    }



    public boolean checkPaymentStatus(String token) {

        OrdersGetRequest request = new OrdersGetRequest(token);

        try {
            HttpResponse<Order> response = payPalHttpClient.execute(request);
            Order order = response.result();
            log.warn(order.status());

            if ("APPROVED".equals(order.status())) {
                return true;
            }
        } catch (IOException e) {
           throw new AppException(ErrorCode.PAYPAL_TOKEN_NOT_VALID);
        }
        throw new AppException(ErrorCode.PAYPAL_TOKEN_DENIED);
    }


}
