package com.curady.lectureservice.web.lecture.controller;

import com.curady.lectureservice.global.result.MultipleResult;
import com.curady.lectureservice.global.service.ResponseService;
import com.curady.lectureservice.domain.lecture.service.LectureService;
import com.curady.lectureservice.web.lecture.dto.ResponseLecture;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;
    private final ResponseService responseService;

    @GetMapping("/lectures")
    public MultipleResult<ResponseLecture> getAllLectures() {
        List<ResponseLecture> responseLectures = lectureService.getAllLectures();

        return responseService.getMultipleResult(responseLectures);
    }

    @GetMapping("/lectures/{categoryId}")
    public MultipleResult<ResponseLecture> getAllLectures(@PathVariable Long categoryId) {
        List<ResponseLecture> responseLectures = lectureService.getLecturesByCategoryId(categoryId);

        return responseService.getMultipleResult(responseLectures);
    }
}
