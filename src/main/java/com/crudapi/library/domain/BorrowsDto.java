package com.crudapi.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BorrowsDto {
    private Long id;
    private Long readerId;
    private Long copyId;
    private LocalDate borrowedDate;
    private LocalDate returnedDate;
}
