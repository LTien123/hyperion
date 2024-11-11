package com.fanci.Hyperion_be.service.serviceImpl.paypal;

import com.fanci.Hyperion_be.entity.Paypal;
import com.fanci.Hyperion_be.service.IPaypalService;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class PaypalServiceImpl implements IPaypalService {

    private final APIContext apiContext;

    public Payment createPayment(
            Paypal paypal
    ) throws PayPalRESTException {
        Amount amount = new Amount();
        amount.setCurrency(paypal.getCurrency());
        amount.setTotal(String.format(Locale.forLanguageTag(paypal.getCurrency()), "%.2f",paypal.getTotal()));

        Transaction transaction = new Transaction();
        transaction.setDescription(paypal.getDescription());
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(paypal.getMethod());

        Payment payment = new Payment();
        payment.setIntent(paypal.getIntent());
        payment.setPayer(payer);
        payment.setTransactions(transactions);

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(paypal.getCancelUrl());
        redirectUrls.setReturnUrl(paypal.getSuccessUrl());

        payment.setRedirectUrls(redirectUrls);

        return payment.create(apiContext);
    }

    public Payment executePayment(
            String paymentId,
            String payerId
    ) throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setId(paymentId);

        PaymentExecution execution = new PaymentExecution();
        execution.setPayerId(payerId);

        return payment.execute(apiContext, execution);
    }
}
