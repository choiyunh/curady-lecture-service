package com.curady.lectureservice.web.lecture.controller;

import com.curady.lectureservice.global.result.MultipleResult;
import com.curady.lectureservice.global.result.SingleResult;
import com.curady.lectureservice.global.service.ResponseService;
import com.curady.lectureservice.domain.lecture.service.LectureService;
import com.curady.lectureservice.web.lecture.dto.ResponseLecture;
import com.curady.lectureservice.web.lecture.dto.ResponseLectures;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;
    private final ResponseService responseService;

    @GetMapping("/lectures")
    public MultipleResult<ResponseLectures> getAllLectures(Pageable pageable) {
        List<ResponseLectures> responseLectures = lectureService.getAllLectures(pageable);

        return responseService.getMultipleResult(responseLectures);
    }

    @GetMapping("/lectures/{categoryId}")
    public MultipleResult<ResponseLectures> getAllLecturesByCategoryId(@PathVariable Long categoryId) {
        List<ResponseLectures> responseLectures = lectureService.getLecturesByCategoryId(categoryId);

        return responseService.getMultipleResult(responseLectures);
    }

//    @GetMapping("lectures/{instructorId}")
//    public MultipleResult<ResponseLecture> getAllLecturesByInstructorId(@PathVariable Long instructorId) {
//        List<ResponseLecture> responseLectures = lectureService.getLecturesByInstructorId(instructorId);
//
//        return responseService.getMultipleResult(responseLectures);
//    }

    @GetMapping("/lecture/{lectureId}")
    public SingleResult<ResponseLecture> getLectureById(@PathVariable Long lectureId) {
        ResponseLecture responseLecture = lectureService.getLectureById(lectureId);

        return responseService.getSingleResult(responseLecture);
    }
}
