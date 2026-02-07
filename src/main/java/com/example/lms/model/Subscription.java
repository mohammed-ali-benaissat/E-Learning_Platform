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

public class Subscription {

    private final int id;
    private final User user;
    private final SubscriptionType type;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private boolean active;

    public Subscription(int id,
                        User user,
                        SubscriptionType type,
                        LocalDate startDate,
                        LocalDate endDate) {

        this.id = id;
        this.user = user;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public SubscriptionType getType() {
        return type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }
}

