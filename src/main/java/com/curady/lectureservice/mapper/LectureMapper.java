package com.curady.lectureservice.mapper;

import com.curady.lectureservice.model.Lecture;
import com.curady.lectureservice.vo.ResponseLectures;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LectureMapper {
    LectureMapper INSTANCE = Mappers.getMapper(LectureMapper.class);
    ResponseLectures entityToResponse(Lecture user);
}
