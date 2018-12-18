package com.crudapi.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "borrows")
public class Borrows {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "readerid")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name ="copyid")
    private Copy copy;

//    @Column(name = "copyid")
//    private Long copyId;
//
//    @Column(name = "readerid")
//    private Long readerId;

    @Column(name = "borrowed")
    private LocalDate borrowedDate;

    @Column(name = "returned")
    @Setter
    private LocalDate returnedDate;


}
