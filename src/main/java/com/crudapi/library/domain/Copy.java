package com.crudapi.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "copies")
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "titleid")
    private Long titleId;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "titleid")
    private Title title;

//    @OneToMany(targetEntity = Borrows.class,
//            mappedBy = "copy",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY)
//    private List<Borrows> borrowsList = new ArrayList<>();




}