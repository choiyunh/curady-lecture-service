package com.curady.lectureservice.domain.lecture.repository;

import com.curady.lectureservice.domain.lecture.model.Lecture;
import org.springframework.data.repository.CrudRepository;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
    Lecture findByCode(String code);
}
