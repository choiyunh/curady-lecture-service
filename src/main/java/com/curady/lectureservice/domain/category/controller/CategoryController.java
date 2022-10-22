package com.curady.lectureservice.domain.category.controller;

import com.curady.lectureservice.domain.category.service.CategoryService;
import com.curady.lectureservice.global.result.MultipleResult;
import com.curady.lectureservice.global.service.ResponseService;
import com.curady.lectureservice.domain.category.dto.ResponseCategory;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final ResponseService responseService;

    @Operation(description = "parentId별 카테고리 목록을 조회합니다.")
    @GetMapping("/categories/{parentId}")
    public MultipleResult<ResponseCategory> getCategories(@PathVariable Long parentId) {
        List<ResponseCategory> responseCategories = categoryService.getCategoryByParentId(parentId);

        return responseService.getMultipleResult(responseCategories);
    }
}
