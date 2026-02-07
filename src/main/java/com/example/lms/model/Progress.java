package com.example.lms.model;

import java.time.LocalDate;

public class Progress {

    private final int id;
    private final Enrollment enrollment;
    private final CourseContent courseContent;

    private ProgressStatus status;
    private LocalDate completionDate;

    public Progress(int id, Enrollment enrollment, CourseContent courseContent) {
        this.id = id;
        this.enrollment = enrollment;
        this.courseContent = courseContent;
        this.status = ProgressStatus.NOT_STARTED;
    }

    public int getId() {
        return id;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public CourseContent getCourseContent() {
        return courseContent;
    }

    public ProgressStatus getStatus() {
        return status;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    // ---------- Domain behavior ----------

    public void start() {
        if (status != ProgressStatus.NOT_STARTED) {
            throw new IllegalStateException("Progress already started or completed");
        }
        status = ProgressStatus.IN_PROGRESS;
    }

    public void complete() {
        if (status == ProgressStatus.COMPLETED) {
            throw new IllegalStateException("Progress already completed");
        }
        status = ProgressStatus.COMPLETED;
        completionDate = LocalDate.now();
    }

    public boolean isCompleted() {
        return status == ProgressStatus.COMPLETED;
    }
}
