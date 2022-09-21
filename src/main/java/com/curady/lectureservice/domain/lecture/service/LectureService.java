package com.curady.lectureservice.domain.lecture.service;

import com.curady.lectureservice.web.lecture.dto.ResponseLecture;

import java.util.List;

public interface LectureService {
    List<ResponseLecture> getAllLectures();

    List<ResponseLecture> getLecturesByCategoryId(Long categoryId);
}
