package com.curady.lectureservice.domain.likes.repository;

import com.curady.lectureservice.domain.likes.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByUserIdAndLectureId(Long userId, Long lectureId);
}
