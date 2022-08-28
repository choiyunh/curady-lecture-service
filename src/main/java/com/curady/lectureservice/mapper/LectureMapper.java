package com.curady.lectureservice.mapper;

import com.curady.lectureservice.model.Lecture;
import com.curady.lectureservice.vo.ResponseLecture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LectureMapper {
    LectureMapper INSTANCE = Mappers.getMapper(LectureMapper.class);
    @Mapping(target = "instructorName", source = "instructor.name")
    ResponseLecture entityToResponse(Lecture lecture);
}
