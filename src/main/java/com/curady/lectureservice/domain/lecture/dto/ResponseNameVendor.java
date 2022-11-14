package com.curady.lectureservice.domain.lecture.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseNameVendor {
    private String name;
    private String vendorName;
}
