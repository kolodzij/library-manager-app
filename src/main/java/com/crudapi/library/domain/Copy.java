package com.crudapi.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "copies")
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "titleid")
    private Title title;

    @Column(name = "status")
    @Setter
    private String status;



//    @OneToMany(targetEntity = Borrows.class,
//            mappedBy = "copy",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY)
//    private List<Borrows> borrowsList = new ArrayList<>();




}
