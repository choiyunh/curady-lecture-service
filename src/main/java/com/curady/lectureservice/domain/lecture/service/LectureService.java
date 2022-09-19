package com.curady.lectureservice.domain.lecture.service;

import com.curady.lectureservice.domain.lecture.model.Lecture;

public interface LectureService {
    Iterable<Lecture> getAllLectures();
}
