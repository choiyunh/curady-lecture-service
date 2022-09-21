package com.curady.lectureservice.web.lecture.controller;

import com.curady.lectureservice.global.result.MultipleResult;
import com.curady.lectureservice.global.result.SingleResult;
import com.curady.lectureservice.global.service.ResponseService;
import com.curady.lectureservice.domain.lecture.service.LectureService;
import com.curady.lectureservice.web.lecture.dto.ResponseLecture;
import com.curady.lectureservice.web.lecture.dto.ResponseLectures;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;
    private final ResponseService responseService;

    @GetMapping("/lectures")
    public MultipleResult<ResponseLectures> getAllLectures() {
        List<ResponseLectures> responseLectures = lectureService.getAllLectures();

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
