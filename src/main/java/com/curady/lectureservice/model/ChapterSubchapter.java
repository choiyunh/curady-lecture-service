package com.curady.lectureservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "chapter_subchapter")
public class ChapterSubchapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @ManyToOne
    @JoinColumn(name = "sub_chapter_id")
    private SubChapter subChapter;
}