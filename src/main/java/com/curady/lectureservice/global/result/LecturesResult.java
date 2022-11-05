package com.curady.lectureservice.global.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LecturesResult <T> extends Result {
    private int totalPage;
    private long totalLecture;
    private List<T> data;
}