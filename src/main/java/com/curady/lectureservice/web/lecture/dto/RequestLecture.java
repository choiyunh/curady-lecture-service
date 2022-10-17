package com.curady.lectureservice.web.lecture.dto;

import lombok.Data;

@Data
public class RequestLecture {
    private Long userId = 0L;
    private Long lectureId;
}
