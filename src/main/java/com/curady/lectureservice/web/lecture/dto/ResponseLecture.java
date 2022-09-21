package com.curady.lectureservice.web.lecture.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseLecture {
    private String name;
    private String imagePath;
    private String vendorName;
    private String instructorName;
    private Integer salePrice;
}
