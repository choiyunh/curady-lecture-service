package com.curady.lectureservice.vo;

import com.curady.lectureservice.model.Instructor;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseLectures {
    private String name;
    private String imagePath;
    private String vendorName;
    private Instructor instructor;
    private Integer salePrice;
}
