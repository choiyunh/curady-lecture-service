package com.curady.lectureservice.domain.lecture.specification;


import com.curady.lectureservice.domain.lecture.model.Lecture;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class LectureSpecification {
    public static Specification<Lecture> equalLectureLevel(Integer level) {
        return new Specification<Lecture>() {
            @Override
            public Predicate toPredicate(Root<Lecture> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("level"), level);
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
