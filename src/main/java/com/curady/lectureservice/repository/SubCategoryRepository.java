package com.curady.lectureservice.repository;

import com.curady.lectureservice.model.SubCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubCategoryRepository extends CrudRepository<SubCategory, Long> {
    Optional<SubCategory> findById(Long id);
}
