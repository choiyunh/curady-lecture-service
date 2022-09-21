package com.curady.lectureservice.domain.lecture.service;

import com.curady.lectureservice.web.lecture.dto.ResponseLecture;
import com.curady.lectureservice.web.lecture.dto.ResponseLectures;

import java.util.List;

public interface LectureService {
    List<ResponseLectures> getAllLectures();
    List<ResponseLectures> getLecturesByCategoryId(Long categoryId);
    List<ResponseLectures> getLecturesByInstructorId(Long instructorId);
    ResponseLecture getLectureById(Long lectureId);
}
