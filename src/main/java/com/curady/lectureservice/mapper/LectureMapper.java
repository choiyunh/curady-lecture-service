package com.curady.lectureservice.mapper;

import com.curady.lectureservice.domain.lecture.model.Lecture;
import com.curady.lectureservice.web.lecture.dto.ResponseLecture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LectureMapper {
    LectureMapper INSTANCE = Mappers.getMapper(LectureMapper.class);
    @Mapping(target = "instructorName", source = "instructor.name")
    List<ResponseLecture> lecturesToResponses(List<Lecture> lecture);
}
