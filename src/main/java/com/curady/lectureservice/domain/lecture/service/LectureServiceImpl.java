package com.curady.lectureservice.domain.lecture.service;

import com.curady.lectureservice.domain.lecture.model.Lecture;
import com.curady.lectureservice.domain.category.repository.CategoryRepository;
import com.curady.lectureservice.domain.lecture.repository.LectureRepository;
import com.curady.lectureservice.global.advice.exception.LectureNotFoundException;
import com.curady.lectureservice.mapper.LectureMapper;
import com.curady.lectureservice.web.lecture.dto.ResponseLecture;
import com.curady.lectureservice.web.lecture.dto.ResponseLectures;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ResponseLectures> getAllLectures() {
        return LectureMapper.INSTANCE.lecturesToResponses(lectureRepository.findAll());
    }

    @Override
    public List<ResponseLectures> getLecturesByCategoryId(Long categoryId) {
        return LectureMapper.INSTANCE.lecturesToResponses(lectureRepository.findAllByCategoryId(categoryId));
    }

    @Override
    public List<ResponseLectures> getLecturesByInstructorId(Long instructorId) {
        return LectureMapper.INSTANCE.lecturesToResponses(lectureRepository.findAllByInstructorId(instructorId));
    }

    @Override
    @Transactional
    public ResponseLecture getLectureById(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(LectureNotFoundException::new);
        return LectureMapper.INSTANCE.lectureToResponse(lecture);
    }
}
