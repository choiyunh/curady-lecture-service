package com.curady.lectureservice.controller;

import com.curady.lectureservice.mapper.LectureMapper;
import com.curady.lectureservice.model.Lecture;
import com.curady.lectureservice.service.LectureService;
import com.curady.lectureservice.vo.ResponseLecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lecture-service")
public class LectureController {
    Environment env;
    LectureService lectureService;

    @Autowired
    public LectureController(Environment env, LectureService lectureService) {
        this.env = env;
        this.lectureService = lectureService;
    }

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's working in user service on PORT %s",
                env.getProperty("local.server.port"));
    }


    @GetMapping("/lecture")
    public ResponseEntity<List<ResponseLecture>> getAllLectures() {
        Iterable<Lecture> lectures = lectureService.getAllLectures();

        List<ResponseLecture> result = new ArrayList<>();
        lectures.forEach(v -> {
            result.add(LectureMapper.INSTANCE.entityToResponse(v));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/lecture/{subCategoryId}")
    public ResponseEntity<List<ResponseLecture>> getLecturesBySubCategory(@PathVariable Long subCategoryId) {
        Iterable<Lecture> lectures = lectureService.getLecturesBySubCategory(subCategoryId);

        List<ResponseLecture> result = new ArrayList<>();
        lectures.forEach(v -> {
            result.add(LectureMapper.INSTANCE.entityToResponse(v));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
