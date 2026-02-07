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

public class Review {

    private final int id;
    private final Student student;
    private final Course course;
    private final int rating;
    private final String comment;
    private final LocalDate reviewDate;

    private Review(Builder builder) {
        if (builder.rating < 1 || builder.rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.id = builder.id;
        this.student = builder.student;
        this.course = builder.course;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.reviewDate = builder.reviewDate;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    // -------- BUILDER --------
    public static class Builder {

        private int id;
        private Student student;
        private Course course;
        private int rating;
        private String comment;
        private LocalDate reviewDate = LocalDate.now();

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder student(Student student) {
            this.student = student;
            return this;
        }

        public Builder course(Course course) {
            this.course = course;
            return this;
        }

        public Builder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder reviewDate(LocalDate reviewDate) {
            this.reviewDate = reviewDate;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}
