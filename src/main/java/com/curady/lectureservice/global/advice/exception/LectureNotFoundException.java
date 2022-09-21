package com.curady.lectureservice.global.advice.exception;

public class LectureNotFoundException extends RuntimeException {
    public LectureNotFoundException() {
    }

    public LectureNotFoundException(String message) {
        super(message);
    }

    public LectureNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

