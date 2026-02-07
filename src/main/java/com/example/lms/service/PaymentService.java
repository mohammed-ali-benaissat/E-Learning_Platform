package com.example.lms.service;

import com.example.lms.model.Payment;
import com.example.lms.model.User;

import java.time.LocalDate;

public class PaymentService {

    public Payment processPayment(int id, User user, double amount) {
        Payment payment = new Payment(id, user, amount, LocalDate.now());

        // simulate success
        payment.markPaid();

        return payment;
    }
}
