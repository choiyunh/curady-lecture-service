package com.curady.lectureservice.web.lecture.dto;

import lombok.Data;

@Data
public class RequestLecture {
    private Long userId;
    private Long lectureId;
}
