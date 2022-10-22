package com.curady.lectureservice.domain.course.service;

import com.curady.lectureservice.domain.course.model.Course;
import com.curady.lectureservice.domain.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public Boolean isInCourse(String userId, Long lectureId) {
        return courseRepository.existsByUserIdAndLectureId(Long.valueOf(userId), lectureId);
    }

    public void createCourse(String userId, Long lectureId) {
        courseRepository.save(Course.builder()
                .userId(Long.valueOf(userId))
                .lectureId(lectureId)
                .build());
    }
}
