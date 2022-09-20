package com.curady.lectureservice.domain.lecture.service;

import com.curady.lectureservice.domain.lecture.model.Lecture;
import com.curady.lectureservice.domain.category.repository.CategoryRepository;
import com.curady.lectureservice.domain.lecture.repository.LectureRepository;
import com.curady.lectureservice.domain.lecture.service.LectureService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Iterable<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }
}
