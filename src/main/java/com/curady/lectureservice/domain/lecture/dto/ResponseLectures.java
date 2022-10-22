package com.curady.lectureservice.domain.lecture.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseLectures {
    private Long id;
    private String name;
    private String imagePath;
    private String vendorName;
    private String instructorName;
    private Integer salePrice;
}
