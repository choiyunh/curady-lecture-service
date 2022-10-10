package com.curady.lectureservice.global.advice;

import com.curady.lectureservice.global.advice.exception.CategoryNotFoundException;
import com.curady.lectureservice.global.advice.exception.LectureNotFoundException;
import com.curady.lectureservice.global.result.Result;
import com.curady.lectureservice.global.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice {
    private final ResponseService responseService;

    @ExceptionHandler(LectureNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result LectureNotFoundException() {
        return responseService.getFailureResult(-201, "존재하지 않는 강의입니다.");
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result categoryNotFoundException() {
        return responseService.getFailureResult(-202, "존재하지 않는 카테고리입니다.");
    }
}
