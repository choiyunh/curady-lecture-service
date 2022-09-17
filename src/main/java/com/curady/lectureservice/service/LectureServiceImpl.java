package com.curady.lectureservice.service;

import com.curady.lectureservice.model.Lecture;
import com.curady.lectureservice.repository.CategoryRepository;
import com.curady.lectureservice.repository.LectureRepository;
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
