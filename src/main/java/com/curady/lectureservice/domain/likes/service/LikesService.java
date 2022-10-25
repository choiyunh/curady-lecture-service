package com.curady.lectureservice.domain.likes.service;


import com.curady.lectureservice.domain.lecture.repository.LectureRepository;
import com.curady.lectureservice.domain.likes.model.Likes;
import com.curady.lectureservice.domain.likes.repository.LikesRepository;
import com.curady.lectureservice.global.advice.exception.LectureNotFoundException;
import com.curady.lectureservice.global.advice.exception.LikesAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LikesService {
    private final LikesRepository likesRepository;
    private final LectureRepository lectureRepository;

    public void createLikes(String userId, Long lectureId) {
        lectureRepository.findById(lectureId).orElseThrow(LectureNotFoundException::new);
        Optional<Likes> likes = likesRepository.findByUserIdAndLectureId(Long.valueOf(userId), lectureId);
        if (likes.isPresent()) {
            throw new LikesAlreadyExistsException();
        }
        likesRepository.save(Likes.builder()
                .userId(Long.valueOf(userId))
                .lectureId(lectureId)
                .build());
    }
}

