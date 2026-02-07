/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lms.model;

/**
 *
 * @author Projects Lab
 */


import java.time.LocalDate;

public class Payment {

    private final int id;
    private final User user;
    private final double amount;
    private final LocalDate date;
    private PaymentStatus status;

    public Payment(int id, User user, double amount, LocalDate now) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.date = now;
        this.status = PaymentStatus.PENDING;
    }

    public void markPaid() {
        this.status = PaymentStatus.PAID;
    }

    public void markFailed() {
        this.status = PaymentStatus.FAILED;
    }

    public PaymentStatus getStatus() {
        return status;
    }
    
    public boolean isPaid() {
        return status == PaymentStatus.PAID;
    }
}
