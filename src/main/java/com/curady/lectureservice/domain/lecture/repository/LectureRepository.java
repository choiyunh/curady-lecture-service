package com.curady.lectureservice.domain.lecture.repository;

import com.curady.lectureservice.domain.lecture.model.Lecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long>, JpaSpecificationExecutor<Lecture> {
    Page<Lecture> findAll(Specification<Lecture> specification, Pageable pageable);
    Page<Lecture> findAllByCategoryId(Long categoryId, Pageable pageable);

    List<Lecture> findAllByInstructorId(Long instructorId);

    Optional<Lecture> findById(Long lectureId);
}
