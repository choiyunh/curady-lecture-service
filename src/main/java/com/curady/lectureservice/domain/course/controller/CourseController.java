package com.curady.lectureservice.domain.course.controller;

import com.curady.lectureservice.domain.course.service.CourseService;
import com.curady.lectureservice.global.result.Result;
import com.curady.lectureservice.global.result.SingleResult;
import com.curady.lectureservice.global.service.ResponseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final ResponseService responseService;
    private final CourseService courseService;

    @Operation(summary = "강의 수강 여부 조회", description = "해당 유저의 강의 수강 여부를 반환합니다 (true/false)")
    @GetMapping("/auth/{lectureId}/course")
    public SingleResult<Boolean> isInCourse(@RequestHeader("X-Authorization-Id") String userId,
                                            @PathVariable Long lectureId) {
        return responseService.getSingleResult(courseService.isInCourse(userId, lectureId));
    }

    @Operation(summary = "강의 수강 등록", description = "강의 수강 등록")
    @PostMapping("/auth/{lectureId}/course")
    public Result createCourse(@RequestHeader("X-Authorization-Id") String userId,
                               @PathVariable Long lectureId) {
        courseService.createCourse(userId, lectureId);
        return responseService.getSuccessResult();
    }
}
