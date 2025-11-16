package com.example.lms.model;



public final class User {
    private Long id;
    private final String name;
    private final int age;
    private final String phoneNumber;
    private final String email;
    private final String password;

    private User(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
        this.password = builder.password;
    }

    public Long getId(){ return  id;}
    public String getName(){return  name;}
    public int getAge(){return age;}
    public String getPhoneNumber(){return phoneNumber;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}

    public static class Builder{
        private Long id;
        private String name;
        private int age;
        private String phoneNumber;
        private String email;
        private String password;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
            this.age = age;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
