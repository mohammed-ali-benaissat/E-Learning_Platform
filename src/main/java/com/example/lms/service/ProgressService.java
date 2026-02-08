package com.example.lms.service;

import com.example.lms.model.CourseContent;
import com.example.lms.model.Enrollment;
import com.example.lms.model.Progress;
import com.example.lms.model.ProgressStatus;

import java.util.List;

public class ProgressService {

    /**
     * Update progress for a specific content
     */
    public Progress updateProgress(
            Enrollment enrollment,
            CourseContent content,
            List<Progress> progresses) {

        // find existing progress
        Progress progress = findProgress(enrollment, content, progresses);

        if (progress == null) {
            // create progress if it does not exist
            progress = new Progress(
                    generateId(),
                    enrollment,
                    content
            );
            progresses.add(progress);
        }

        // update state
        progress.start();
        progress.complete();

        return progress;
    }

    /**
     * Check if course is completed
     */
    public boolean isCourseCompleted(
            Enrollment enrollment,
            List<CourseContent> contents,
            List<Progress> progresses) {

        for (CourseContent content : contents) {
            Progress progress = findProgress(enrollment, content, progresses);

            if (progress == null ||
                    progress.getStatus() != ProgressStatus.COMPLETED) {
                return false;
            }
        }
        return true;
    }

    // ----------------- helpers -----------------

    private Progress findProgress(
            Enrollment enrollment,
            CourseContent content,
            List<Progress> progresses) {

        for (Progress progress : progresses) {
            if (progress.getEnrollment().equals(enrollment)
                    && progress.getCourseContent().equals(content)) {
                return progress;
            }
        }
        return null;
    }

    private int generateId() {
        return (int) (Math.random() * 100_000);
    }
}
