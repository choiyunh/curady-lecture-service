package com.curady.lectureservice.repository;

import com.curady.lectureservice.model.Lecture;
import com.curady.lectureservice.model.SubCategory;
import org.springframework.data.repository.CrudRepository;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
    Lecture findByCode(String code);
    Iterable<Lecture> findBySubCategory(SubCategory subCategory);
}
