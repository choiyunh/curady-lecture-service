package com.curady.lectureservice.repository;

import com.curady.lectureservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoriesByParentId(Long parentId);
}