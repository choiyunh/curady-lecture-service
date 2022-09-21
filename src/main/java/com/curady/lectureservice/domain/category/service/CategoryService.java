package com.curady.lectureservice.domain.category.service;

import com.curady.lectureservice.domain.category.repository.CategoryRepository;
import com.curady.lectureservice.mapper.CategoryMapper;
import com.curady.lectureservice.web.lecture.dto.ResponseCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<ResponseCategory> getCategoryByParentId(Long parentId) {
        return CategoryMapper.INSTANCE.categoryToResponse(
                categoryRepository.findAllByParentId(parentId));
    }
}
