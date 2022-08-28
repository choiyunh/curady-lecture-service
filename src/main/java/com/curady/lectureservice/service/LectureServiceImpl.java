package com.curady.lectureservice.service;

import com.curady.lectureservice.model.Lecture;
import com.curady.lectureservice.model.SubCategory;
import com.curady.lectureservice.repository.LectureRepository;
import com.curady.lectureservice.repository.SubCategoryRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class LectureServiceImpl implements LectureService {
    LectureRepository lectureRepository;
    SubCategoryRepository subCategoryRepository;

    @Autowired
    public LectureServiceImpl(LectureRepository lectureRepository, SubCategoryRepository subCategoryRepository) {
        this.lectureRepository = lectureRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public Iterable<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    public Iterable<Lecture> getLecturesBySubCategory(Long subCategoryId) {
        Optional<SubCategory> subCategory = subCategoryRepository.findById(subCategoryId);

        if (subCategory.isEmpty())
            throw new RuntimeException();

        return lectureRepository.findBySubCategory(subCategory.get());
    }
}
