package com.example.lms.service;

import com.example.lms.model.*;

import java.util.List;

public class ProgressService {

    public void updateProgress(
            Enrollment enrollment,
            CourseContent content,
            List<Progress> progresses) {

        Progress progress = findProgress(enrollment, content, progresses);

        if (progress == null) {
            progress = new Progress(
                    generateId(),
                    enrollment,
                    content
            );
            progresses.add(progress);
        }

        // domain-driven state changes
        if (progress.getStatus() == ProgressStatus.NOT_STARTED) {
            progress.start();
        }

        progress.complete();

        if (isCourseCompleted(enrollment, progresses)) {
            signalCourseCompleted(enrollment);
        }
    }

    private Progress findProgress(
            Enrollment enrollment,
            CourseContent content,
            List<Progress> progresses) {

        for (Progress p : progresses) {
            if (p.getEnrollment().equals(enrollment)
                    && p.getCourseContent().equals(content)) {
                return p;
            }
        }
        return null;
    }

    private boolean isCourseCompleted(
            Enrollment enrollment,
            List<Progress> progresses) {

        return progresses.stream()
                .filter(p -> p.getEnrollment().equals(enrollment))
                .allMatch(Progress::isCompleted);
    }

    private void signalCourseCompleted(Enrollment enrollment) {
        System.out.println(
                "Course completed for enrollment: " + enrollment.getId()
        );
    }

    private int generateId() {
        return (int) (Math.random() * 100_000);
    }
}
