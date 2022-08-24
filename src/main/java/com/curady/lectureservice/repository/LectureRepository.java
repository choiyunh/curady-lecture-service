package com.curady.lectureservice.repository;

import com.curady.lectureservice.model.Lecture;
import org.springframework.data.repository.CrudRepository;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
    @Override
    Iterable<Lecture> findAll();

    Lecture findByCode(String code);
}
