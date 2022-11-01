package com.curady.lectureservice.domain.course.repository;

import com.curady.lectureservice.domain.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Boolean existsByUserIdAndLectureId(Long userId, Long lectureId);

    List<Course> findAllByUserId(Long userId);
}
