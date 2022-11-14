package com.curady.lectureservice.mapper;

import com.curady.lectureservice.domain.lecture.dto.ResponseNameVendor;
import com.curady.lectureservice.domain.lecture.model.Lecture;
import com.curady.lectureservice.domain.lecture.dto.ResponseLectures;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LectureMapper {
    LectureMapper INSTANCE = Mappers.getMapper(LectureMapper.class);

    @Mapping(target = "instructorName", source = "instructor.name")
    ResponseLectures lectureToResponse(Lecture lecture);

    List<ResponseLectures> lecturesToResponseList(List<Lecture> lecture);

    ResponseNameVendor lectureToNameVendor(Lecture lecture);

    List<ResponseNameVendor> lecturesToNameVendorList(List<Lecture> lectures);
}
