package com.curady.lectureservice.domain.lecture.repository;

import com.curady.lectureservice.domain.lecture.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findAllByCategoryId(Long categoryId);

    List<Lecture> findAllByInstructorId(Long instructorId);

    Optional<Lecture> findById(Long lectureId);
}
