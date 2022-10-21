package com.curady.lectureservice.domain.lecture.service;

import com.curady.lectureservice.domain.category.repository.CategoryRepository;
import com.curady.lectureservice.domain.lecture.model.Lecture;
import com.curady.lectureservice.domain.lecture.repository.LectureRepository;
import com.curady.lectureservice.domain.lecture.specification.LectureSpecification;
import com.curady.lectureservice.domain.lectureLog.model.LectureLog;
import com.curady.lectureservice.domain.lectureLog.repository.LectureLogRepository;
import com.curady.lectureservice.domain.lectureTag.model.LectureTag;
import com.curady.lectureservice.global.advice.exception.CategoryNotFoundException;
import com.curady.lectureservice.global.advice.exception.LectureNotFoundException;
import com.curady.lectureservice.global.result.LecturesResult;
import com.curady.lectureservice.global.service.ResponseService;
import com.curady.lectureservice.mapper.LectureMapper;
import com.curady.lectureservice.web.lecture.dto.RequestLecture;
import com.curady.lectureservice.web.lecture.dto.ResponseLecture;
import com.curady.lectureservice.web.lecture.dto.ResponseLectures;
import com.curady.lectureservice.web.lecture.dto.ResponseTag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final CategoryRepository categoryRepository;
    private final ResponseService responseService;
    private final LectureLogRepository lectureLogRepository;

    @Override
    @Transactional(readOnly = true)
    public LecturesResult<ResponseLectures> getAllLectures(Pageable pageable,
                                                           Map<String, String> filterKeys) {
        Specification<Lecture> specification = (root, query, criteriaBuilder) -> null;
        if (filterKeys.get("level") != null) {
            specification = specification.and(LectureSpecification.equalLectureLevel(Integer.valueOf(filterKeys.get("level"))));
        }
        if (filterKeys.get("price") != null) {
            specification = specification.and(LectureSpecification.betweenPrice(Integer.valueOf(filterKeys.get("price"))));
        }
        Page<Lecture> lecturePage = lectureRepository.findAll(specification, pageable);
        List<ResponseLectures> responseLectures =
                LectureMapper.INSTANCE.lecturesToResponseList(lecturePage.getContent());

        return responseService.getLecturesResult(lecturePage.getTotalPages(), responseLectures);
    }

    @Override
    @Transactional(readOnly = true)
    public LecturesResult<ResponseLectures> getLecturesByCategoryId(Long categoryId,
                                                                    Pageable pageable,
                                                                    Map<String, String> filterKeys) {
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
    public ResponseLecture getLecture(RequestLecture requestLecture) {
        Lecture lecture = lectureRepository.findById(requestLecture.getLectureId())
                .orElseThrow(LectureNotFoundException::new);
        List<LectureTag> lectureTags = lecture.getLectureTags();
        List<ResponseTag> responseTags = new ArrayList<>();
        lectureTags.forEach(v -> {
            responseTags.add
                    (ResponseTag.builder()
                            .tagId(v.getTag().getId())
                            .tagName(v.getTag().getName())
                            .build());
        });
        lectureLogRepository.save(
                LectureLog.builder()
                        .userId(requestLecture.getUserId())
                        .lectureId(requestLecture.getLectureId())
                        .build());

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
