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

public class Certificate {

    private final int id;
    private final Student student;
    private final Course course;
    private final LocalDate issueDate;
    private final String certificateCode;
    private final String certificateUrl;

    private Certificate(Builder builder) {
        this.id = builder.id;
        this.student = builder.student;
        this.course = builder.course;
        this.issueDate = builder.issueDate;
        this.certificateCode = builder.certificateCode;
        this.certificateUrl = builder.certificateUrl;
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

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public String getCertificateUrl() {
        return certificateUrl;
    }

    // ---------- BUILDER ----------
    public static class Builder {

        private int id;
        private Student student;
        private Course course;
        private LocalDate issueDate;
        private String certificateCode;
        private String certificateUrl;

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

        public Builder issueDate(LocalDate issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder certificateCode(String certificateCode) {
            this.certificateCode = certificateCode;
            return this;
        }

        public Builder certificateUrl(String certificateUrl) {
            this.certificateUrl = certificateUrl;
            return this;
        }

        public Certificate build() {
            return new Certificate(this);
        }
    }
}
