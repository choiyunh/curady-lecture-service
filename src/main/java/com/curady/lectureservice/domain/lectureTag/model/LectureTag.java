package com.curady.lectureservice.domain.lectureTag.model;

import com.curady.lectureservice.domain.tag.model.Tag;
import com.curady.lectureservice.domain.lecture.model.Lecture;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "lecture_tag")
public class LectureTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
