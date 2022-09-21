package com.curady.lectureservice.web.lecture.dto;

import com.curady.lectureservice.domain.lectureTag.model.LectureTag;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseLecture {
    private Long id;
    private String name;
    private String imagePath;
    private String vendorUrl;
    private String vendorName;
    private String description;
    private Integer salePrice;
    private Integer deadline;
    private String infoPath;
    private String infoImagePath;
    private Integer level;

    private String instructorName;
    private List<LectureTag> lectureTags;
}