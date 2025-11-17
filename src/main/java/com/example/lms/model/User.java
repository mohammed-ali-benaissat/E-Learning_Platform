package com.example.lms.model;

/**
 * Abstract base class for all users in the system.
 * Immutable. Use builder to create instances.
 */
public abstract class User {
    private final int id;
    private final String name;
    private final int age;
    private final String phoneNumber;
    private final String email;
    private final String password;

    protected User(Builder<?> builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.password = builder.password;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    // Common methods
    public void login() {
        System.out.println(name + " logged in.");
    }

    public void logout() {
        System.out.println(name + " logged out.");
    }

    /**
     * Abstract builder class for User.
     * Subclasses should extend this builder.
     */
    public abstract static class Builder<T extends Builder<T>> {
        private int id;
        private String name;
        private int age;
        private String phoneNumber;
        private String email;
        private String password;

        public T id(int id) { this.id = id; return self(); }
        public T name(String name) { this.name = name; return self(); }
        public T age(int age) { this.age = age; return self(); }
        public T phoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; return self(); }
        public T email(String email) { this.email = email; return self(); }
        public T password(String password) { this.password = password; return self(); }

        protected abstract T self();
        public abstract User build();
    }
}
