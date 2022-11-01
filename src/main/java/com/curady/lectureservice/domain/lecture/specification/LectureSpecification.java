package com.curady.lectureservice.domain.lecture.specification;


import com.curady.lectureservice.domain.lecture.model.Lecture;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;

public class LectureSpecification {
    public static Specification<Lecture> equalLectureLevel(List<Integer> levelList) {
        return new Specification<Lecture>() {
            @Override
            public Predicate toPredicate(Root<Lecture> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.distinct(true);
                if (Lecture.class.equals(query.getResultType())) {
                    root.fetch("instructor", JoinType.LEFT);
                }
                return criteriaBuilder.and(root.get("level").in(levelList));
            }
        };
    }

    public static Specification<Lecture> equalLectureCategory(Long category) {
        return new Specification<Lecture>() {

            @Override
            public Predicate toPredicate(Root<Lecture> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.distinct(true);
                if (Lecture.class.equals(query.getResultType())) {
                    root.fetch("instructor", JoinType.LEFT);
                }
                return criteriaBuilder.equal(root.get("category"), category);
            }
        };
    }

    public static Specification<Lecture> betweenPrice(int startPrice, int endPrice) {
        return new Specification<Lecture>() {
            @Override
            public Predicate toPredicate(Root<Lecture> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.distinct(true);
                if (Lecture.class.equals(query.getResultType())) {
                    root.fetch("instructor", JoinType.LEFT);
                }
                return criteriaBuilder.between(root.get("salePrice"), startPrice, endPrice);
            }
        };
    }

    public static Specification<Lecture> likeLectureName(String searchWord) {
        return new Specification<Lecture>() {
            @Override
            public Predicate toPredicate(Root<Lecture> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.distinct(true);
                if (Lecture.class.equals(query.getResultType())) {
                    root.fetch("instructor", JoinType.LEFT);
                }
                return criteriaBuilder.like(root.get("name"), "%" + searchWord + "%");
            }
        };
    }

    public static Specification<Lecture> likeLectureDescription(String searchWord) {
        return new Specification<Lecture>() {
            @Override
            public Predicate toPredicate(Root<Lecture> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("description"), "%" + searchWord + "%");
            }
        };
    }
}
