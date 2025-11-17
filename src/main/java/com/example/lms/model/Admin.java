package com.example.lms.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an admin in the system.
 */
public class Admin extends User {
    private final List<String> managedUsers;

    private Admin(Builder builder) {
        super(builder);
        this.managedUsers = builder.managedUsers;
    }

    public void manageUser(String user) {
        managedUsers.add(user);
        System.out.println(getName() + " managed user " + user);
    }

    public List<String> getManagedUsers() {
        return List.copyOf(managedUsers);
    }

    public static class Builder extends User.Builder<Builder> {
        private List<String> managedUsers = new ArrayList<>();

        public Builder managedUsers(List<String> users) {
            this.managedUsers = new ArrayList<>(users);
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Admin build() {
            return new Admin(this);
        }
    }
}
