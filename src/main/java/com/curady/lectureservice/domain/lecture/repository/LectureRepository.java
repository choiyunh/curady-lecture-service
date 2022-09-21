package com.curady.lectureservice.domain.lecture.repository;

import com.curady.lectureservice.domain.lecture.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    Lecture findByCode(String code);
    List<Lecture> findAllByCategoryId(Long categoryId);
}
