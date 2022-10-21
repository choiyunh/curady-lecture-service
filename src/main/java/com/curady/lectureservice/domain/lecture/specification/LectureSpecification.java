package com.curady.lectureservice.domain.lecture.specification;


import com.curady.lectureservice.domain.lecture.model.Lecture;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class LectureSpecification {
    public static Specification<Lecture> equalLectureLevel(List<Integer> levelList) {
        return new Specification<Lecture>() {
            @Override
            public Predicate toPredicate(Root<Lecture> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.and(root.get("level").in(levelList));
            }
        };
    }

    public static Specification<Lecture> equalLectureCategory(Long category) {
        return new Specification<Lecture>() {
            @Override
            public Predicate toPredicate(Root<Lecture> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("category"), category);
            }
        };
    }

    public static Specification<Lecture> betweenPrice(Integer salePrice) {
        return new Specification<Lecture>() {
            @Override
            public Predicate toPredicate(Root<Lecture> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get("salePrice"), 0, salePrice);
            }
        };
    }
}
