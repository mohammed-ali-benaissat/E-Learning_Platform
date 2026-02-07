/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lms.model;

/**
 *
 * @author Projects Lab
 */

public final class CourseContent {

    private final int id;
    private final String title;
    private final String description;
    private final int order;          // lesson order inside the course
    private final int duration;       // in minutes
    private final ContentType contentType;
    private final String contentUrl;
    private final Course course;

    private CourseContent(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.order = builder.order;
        this.duration = builder.duration;
        this.contentType = builder.contentType;
        this.contentUrl = builder.contentUrl;
        this.course = builder.course;
    }

    // -------- Getters (immutability) --------

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getOrder() {
        return order;
    }

    public int getDuration() {
        return duration;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public Course getCourse() {
        return course;
    }

    // -------- Builder --------

    public static class Builder {
        private int id;
        private String title;
        private String description;
        private int order;
        private int duration;
        private ContentType contentType;
        private String contentUrl;
        private Course course;

        public Builder id(int id) {
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

        public Builder order(int order) {
            this.order = order;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder contentType(ContentType contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder contentUrl(String contentUrl) {
            this.contentUrl = contentUrl;
            return this;
        }

        public Builder course(Course course) {
            this.course = course;
            return this;
        }

        public CourseContent build() {
            return new CourseContent(this);
        }
    }
}
