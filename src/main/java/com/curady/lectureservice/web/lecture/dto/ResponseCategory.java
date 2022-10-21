package com.curady.lectureservice.web.lecture.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseCategory {
    private Long id;
    private String name;
}