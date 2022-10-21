package com.curady.lectureservice.domain.lecture.service;

import com.curady.lectureservice.domain.lecture.model.Lecture;
import com.curady.lectureservice.domain.lecture.repository.LectureRepository;
import com.curady.lectureservice.mapper.LectureMapper;
import com.curady.lectureservice.web.lecture.dto.ResponseLectures;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Transactional
@SpringBootTest
@ActiveProfiles("local")
class LectureServiceImplTest {
    @Autowired
    private LectureRepository lectureRepository;
    Pageable pageable = PageRequest.of(1, 24);

    @Test
    void getAllLectures() {
        Page<Lecture> lecturePage = lectureRepository.findAll(pageable);
        List<ResponseLectures> responseLectures =
                LectureMapper.INSTANCE.lecturesToResponseList(lecturePage.getContent());
        for (int i = 0; i < 24; i++) {
            Assertions.assertThat(responseLectures.get(i).getId()).isEqualTo(lecturePage.getContent().get(i).getId());
            Assertions.assertThat(responseLectures.get(i).getName()).isEqualTo(lecturePage.getContent().get(i).getName());
            Assertions.assertThat(responseLectures.get(i).getImagePath()).isEqualTo(lecturePage.getContent().get(i).getImagePath());
            Assertions.assertThat(responseLectures.get(i).getVendorName()).isEqualTo(lecturePage.getContent().get(i).getVendorName());
            Assertions.assertThat(responseLectures.get(i).getSalePrice()).isEqualTo(lecturePage.getContent().get(i).getSalePrice());
            Assertions.assertThat(responseLectures.get(i).getInstructorName()).isEqualTo(lecturePage.getContent().get(i).getInstructor().getName());
        }
    }
}