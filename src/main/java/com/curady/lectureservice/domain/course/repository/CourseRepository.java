package com.curady.lectureservice.domain.course.repository;

import com.curady.lectureservice.domain.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Boolean existsByUserIdAndLectureId(Long userId, Long lectureId);
}
