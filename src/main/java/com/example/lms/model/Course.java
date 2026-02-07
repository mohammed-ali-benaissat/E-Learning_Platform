/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lms.model;

import java.time.LocalDate;

import com.example.lms.model.Instructor;



/**
 *
 * @author Projects Lab
 */

//this class is set to final to prevent inheritence 
public final class Course {
    
    //these fields are set to final to enforce read by getters and assign value once
    private final int id;
    private final String title;
    private final String description;
    private final String category;
    private final String level;
    private final int duration;        // in hours
    private final double price;
    private final boolean published;
    private final Instructor instructor;
    private final LocalDate publishDate;
    
    
    //this constructor is set to private to prevent new Course()
    private Course(Builder builder){
        
        //copy data from Builder
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.category = builder.category;
        this.level = builder.level;
        this.duration = builder.duration;
        this.price = builder.price;
        this.published = builder.published;
        this.instructor = builder.instructor;
        this.publishDate = builder.publishDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getLevel() {
        return level;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPublished() {
        return published;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }
    
    
    // ----------- Builder -----------

    //why static it does not depend on existing Course/ this builder is mutable and temprory
    public static class Builder{
        private int id;
        private String title;
        private String description;
        private String category;
        private String level;
        private int duration;
        private double price;
        private boolean published;
        private Instructor instructor;
        private LocalDate publishDate;
        
        //it returns this for chaining 
        
        public Builder id(int id){
            this.id = id;
                    return this;
        }
        
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder level(String level) {
            this.level = level;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder published(boolean published) {
            this.published = published;
            return this;
        }

        public Builder instructor(Instructor instructor) {
            this.instructor = instructor;
            return this;
        }

        public Builder publishDate(LocalDate publishDate) {
            this.publishDate = publishDate;
            return this;
        }

        
        //creation point
        public Course build() {
            return new Course(this);
        }
        
    }
    
    
    
}
