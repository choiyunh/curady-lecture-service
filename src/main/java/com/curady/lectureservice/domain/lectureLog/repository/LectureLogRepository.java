package com.curady.lectureservice.domain.lectureLog.repository;

import com.curady.lectureservice.domain.lectureLog.model.LectureLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureLogRepository extends JpaRepository<LectureLog, Long> {
}
