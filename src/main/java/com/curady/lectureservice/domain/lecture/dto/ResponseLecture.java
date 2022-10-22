package com.curady.lectureservice.domain.lecture.dto;

import com.curady.lectureservice.domain.tag.dto.ResponseTag;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
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
    private List<ResponseTag> lectureTags;
}