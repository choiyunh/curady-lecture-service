package com.curady.lectureservice.mapper;

import com.curady.lectureservice.domain.category.model.Category;
import com.curady.lectureservice.web.lecture.dto.ResponseCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    List<ResponseCategory> categoryToResponse(List<Category> category);
}