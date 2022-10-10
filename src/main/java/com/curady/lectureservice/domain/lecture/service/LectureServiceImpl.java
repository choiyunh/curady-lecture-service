package com.curady.lectureservice.domain.lecture.service;

import com.curady.lectureservice.domain.category.repository.CategoryRepository;
import com.curady.lectureservice.domain.lecture.model.Lecture;
import com.curady.lectureservice.domain.lecture.repository.LectureRepository;
import com.curady.lectureservice.domain.lectureTag.model.LectureTag;
import com.curady.lectureservice.global.advice.exception.CategoryNotFoundException;
import com.curady.lectureservice.global.advice.exception.LectureNotFoundException;
import com.curady.lectureservice.global.result.LecturesResult;
import com.curady.lectureservice.global.service.ResponseService;
import com.curady.lectureservice.mapper.LectureMapper;
import com.curady.lectureservice.web.lecture.dto.ResponseLecture;
import com.curady.lectureservice.web.lecture.dto.ResponseLectures;
import com.curady.lectureservice.web.lecture.dto.ResponseTag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final CategoryRepository categoryRepository;
    private final ResponseService responseService;

    @Override
    @Transactional
    public LecturesResult<ResponseLectures> getAllLectures(Pageable pageable) {
        Page<Lecture> lecturePage = lectureRepository.findAll(pageable);
        List<ResponseLectures> responseLectures =
                LectureMapper.INSTANCE.lecturesToResponseList(lecturePage.getContent());

        return responseService.getLecturesResult(lecturePage.getTotalPages(), responseLectures);
    }

    @Override
    @Transactional
    public LecturesResult<ResponseLectures> getLecturesByCategoryId(Long categoryId, Pageable pageable) {
        categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new);

        Page<Lecture> lecturePage = lectureRepository.findAllByCategoryId(categoryId, pageable);
        List<ResponseLectures> responseLectures =
                LectureMapper.INSTANCE.lecturesToResponseList(lecturePage.getContent());

        return responseService.getLecturesResult(lecturePage.getTotalPages(), responseLectures);
    }

    @Override
    public List<ResponseLectures> getLecturesByInstructorId(Long instructorId) {
        return LectureMapper.INSTANCE.lecturesToResponseList(lectureRepository.findAllByInstructorId(instructorId));
    }

    @Override
    @Transactional
    public ResponseLecture getLectureById(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(LectureNotFoundException::new);
        List<LectureTag> lectureTags = lecture.getLectureTags();
        List<ResponseTag> responseTags = new ArrayList<>();
        lectureTags.forEach(v -> {
            responseTags.add
                    (ResponseTag.builder()
                            .tagId(v.getTag().getId())
                            .tagName(v.getTag().getName())
                            .build());
        });

        return ResponseLecture.builder()
                .id(lecture.getId())
                .name(lecture.getName())
                .imagePath(lecture.getImagePath())
                .vendorUrl(lecture.getVendorUrl())
                .vendorName(lecture.getVendorName())
                .description(lecture.getDescription())
                .salePrice(lecture.getSalePrice())
                .deadline(lecture.getDeadline())
                .infoPath(lecture.getInfo())
                .infoImagePath(lecture.getInfoImagePath())
                .level(lecture.getLevel())
                .instructorName(lecture.getInstructor().getName())
                .lectureTags(responseTags)
                .build();
    }
}
