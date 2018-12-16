package com.crudapi.library.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name="readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="joined")
    private LocalDate joinedDate;

//    @OneToMany(targetEntity = Borrows.class,
//            mappedBy = "reader",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY)
//    private List<Borrows> borrowsList = new ArrayList<>();

}
