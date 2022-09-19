package com.curady.lectureservice.domain.tag.model;


import com.curady.lectureservice.domain.lectureTag.model.LectureTag;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "tag")
    private List<LectureTag> lectureTags = new ArrayList<>();
}