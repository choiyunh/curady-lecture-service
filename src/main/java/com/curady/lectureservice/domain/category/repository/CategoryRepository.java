package com.curady.lectureservice.domain.category.repository;

import com.curady.lectureservice.domain.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoriesByParentId(Long parentId);
}
