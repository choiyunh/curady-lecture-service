package com.curady.lectureservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String imagePath;
    @Column(nullable = false)
    private String vendorUrl;
    @Column(nullable = false, length = 50)
    private String vendorName;
    @Column(nullable = false, length = 1000)
    private String description;
    @Column(nullable = false)
    private Integer originalPrice;
    @Column(nullable = false)
    private Integer salePrice;
    @Column(nullable = false)
    private Integer deadline;
    @Column(nullable = false, length = 1000)
    private String info;
    @Column(nullable = false, unique = true)
    private String infoImagePath;
    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false, updatable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Date createdAt;
    @Column(nullable = false, updatable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany(mappedBy = "lecture")
    private List<LectureTag> lectureTags = new ArrayList<>();

    @OneToMany(mappedBy = "lecture")
    private List<Chapter> chapters = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
}