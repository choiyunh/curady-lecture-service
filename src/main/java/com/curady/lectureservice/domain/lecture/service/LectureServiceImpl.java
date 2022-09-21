package com.curady.lectureservice.domain.lecture.service;

import com.curady.lectureservice.domain.lecture.model.Lecture;
import com.curady.lectureservice.domain.category.repository.CategoryRepository;
import com.curady.lectureservice.domain.lecture.repository.LectureRepository;
import com.curady.lectureservice.domain.lecture.service.LectureService;
import com.curady.lectureservice.mapper.LectureMapper;
import com.curady.lectureservice.web.lecture.dto.ResponseLecture;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ResponseLecture> getAllLectures() {
        return LectureMapper.INSTANCE.lecturesToResponses(lectureRepository.findAll());
    }

    @Override
    public List<ResponseLecture> getLecturesByCategoryId(Long categoryId) {
        return LectureMapper.INSTANCE.lecturesToResponses(lectureRepository.findAllByCategoryId(categoryId));
    }
}
