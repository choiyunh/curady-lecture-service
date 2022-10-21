package com.curady.lectureservice.domain.lecture.service;

import com.curady.lectureservice.global.result.LecturesResult;
import com.curady.lectureservice.web.lecture.dto.RequestLecture;
import com.curady.lectureservice.web.lecture.dto.ResponseLecture;
import com.curady.lectureservice.web.lecture.dto.ResponseLectures;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface LectureService {
    LecturesResult<ResponseLectures> getLectures(Pageable pageable, Map<String, String> filterKeys);
    ResponseLecture getLecture(RequestLecture requestLecture);
}
