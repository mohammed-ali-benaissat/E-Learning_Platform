/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lms.service;



import com.example.lms.model.Subscription;
import com.example.lms.model.SubscriptionType;
import com.example.lms.model.User;

import java.time.LocalDate;

public class SubscriptionService {

    public Subscription createSubscription(
            int id,
            User user,
            SubscriptionType type,
            LocalDate startDate) {

        LocalDate endDate = calculateEndDate(type, startDate);
        return new Subscription(id, user, type, startDate, endDate);
    }

    public boolean isValid(Subscription subscription) {
        return subscription.isActive()
                && !subscription.getEndDate().isBefore(LocalDate.now());
    }

    public void deactivate(Subscription subscription) {
        subscription.deactivate();
    }

    // 🔒 internal logic
    private LocalDate calculateEndDate(
            SubscriptionType type,
            LocalDate startDate) {

        return switch (type) {
            case MONTHLY -> startDate.plusMonths(1);
            case ANNUAL  -> startDate.plusYears(1);
        };
    }
}
