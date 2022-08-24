package com.curady.lectureservice.service;

import com.curady.lectureservice.model.Lecture;
import com.curady.lectureservice.repository.LectureRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class LectureServiceImpl implements LectureService {
    LectureRepository lectureRepository;

    @Autowired
    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public Iterable<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }
}
