package com.curady.lectureservice.service;

import com.curady.lectureservice.model.Lecture;

public interface LectureService {
    Iterable<Lecture> getAllLectures();
}
