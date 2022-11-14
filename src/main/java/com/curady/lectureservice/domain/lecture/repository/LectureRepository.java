package com.curady.lectureservice.domain.lecture.repository;

import com.curady.lectureservice.domain.lecture.model.Lecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long>, JpaSpecificationExecutor<Lecture> {
    Page<Lecture> findAll(Specification<Lecture> specification, Pageable pageable);

    @Query("select l from Lecture l join fetch l.category join fetch l.instructor where l.id = :lectureId")
    Optional<Lecture> findById(Long lectureId);

    Page<Lecture> findAllByIdIn(List<Long> lectureIds, Pageable pageable);

    List<Lecture> findAllByIdIn(List<Long> lectureIds);
}
