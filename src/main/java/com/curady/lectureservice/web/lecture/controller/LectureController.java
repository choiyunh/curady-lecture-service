package com.curady.lectureservice.web.lecture.controller;

import com.curady.lectureservice.global.result.MultipleResult;
import com.curady.lectureservice.global.result.SingleResult;
import com.curady.lectureservice.global.service.ResponseService;
import com.curady.lectureservice.domain.lecture.service.LectureService;
import com.curady.lectureservice.web.lecture.dto.ResponseLecture;
import com.curady.lectureservice.web.lecture.dto.ResponseLectures;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "전체 강의 목록 조회(페이징 적용)", description = "강의의 전체 목록을 페이지별로 반환합니다. page의 기본값은 1, size는 24, sort는 id,ASC")
    @GetMapping("/lectures")
    public MultipleResult<ResponseLectures> getAllLectures(Pageable pageable) {
        List<ResponseLectures> responseLectures = lectureService.getAllLectures(pageable);

        return responseService.getMultipleResult(responseLectures);
    }

    @Operation(summary = "카테고리별 강의 목록 조회(페이징 적용)", description = "카테고리별 강의의 목록을 페이지별로 반환합니다. page의 기본값은 1, size는 24, sort는 id,ASC")
    @GetMapping("/lectures/{categoryId}")
    public MultipleResult<ResponseLectures> getAllLecturesByCategoryId(@PathVariable Long categoryId, Pageable pageable) {
        List<ResponseLectures> responseLectures = lectureService.getLecturesByCategoryId(categoryId, pageable);

        return responseService.getMultipleResult(responseLectures);
    }

//    @GetMapping("lectures/{instructorId}")
//    public MultipleResult<ResponseLecture> getAllLecturesByInstructorId(@PathVariable Long instructorId) {
//        List<ResponseLecture> responseLectures = lectureService.getLecturesByInstructorId(instructorId);
//
//        return responseService.getMultipleResult(responseLectures);
//    }

    @Operation(summary = "강의 상세 조회", description = "강의의 id를 받아 해당 강의의 상세 정보를 조회")
    @GetMapping("/lecture/{lectureId}")
    public SingleResult<ResponseLecture> getLectureById(@PathVariable Long lectureId) {
        ResponseLecture responseLecture = lectureService.getLectureById(lectureId);

        return responseService.getSingleResult(responseLecture);
    }
}
