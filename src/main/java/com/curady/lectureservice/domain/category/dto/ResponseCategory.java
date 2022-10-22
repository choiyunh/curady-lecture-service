package com.curady.lectureservice.domain.category.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseCategory {
    private Long id;
    private String name;
}