package com.example.lms.repo;

import com.example.lms.model.Subscription;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionRepository {

    private final List<Subscription> subscriptions = new ArrayList<>();

    public void save(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public List<Subscription> findAll() {
        return subscriptions;
    }
}
