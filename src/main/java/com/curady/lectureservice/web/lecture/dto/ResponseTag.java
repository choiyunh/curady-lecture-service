package com.curady.lectureservice.web.lecture.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseTag {
    private Long tagId;
    private String tagName;
}
