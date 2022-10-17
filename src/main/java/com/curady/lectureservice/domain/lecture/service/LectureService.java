package com.curady.lectureservice.domain.lecture.service;

import com.curady.lectureservice.global.result.LecturesResult;
import com.curady.lectureservice.web.lecture.dto.RequestLecture;
import com.curady.lectureservice.web.lecture.dto.ResponseLecture;
import com.curady.lectureservice.web.lecture.dto.ResponseLectures;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LectureService {
    LecturesResult<ResponseLectures> getAllLectures(Pageable pageable);

    LecturesResult<ResponseLectures> getLecturesByCategoryId(Long categoryId, Pageable pageable);

    List<ResponseLectures> getLecturesByInstructorId(Long instructorId);

    ResponseLecture getLecture(RequestLecture requestLecture);
}
