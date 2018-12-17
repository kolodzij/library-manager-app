package com.crudapi.library.mapper;

import com.crudapi.library.domain.Borrows;
import com.crudapi.library.domain.BorrowsDto;
import com.crudapi.library.service.CopyDbService;
import com.crudapi.library.service.ReaderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BorrowsMapper {

    @Autowired
    private ReaderDbService readerDbService;

    @Autowired
    private CopyDbService copyDbService;

    public Borrows mapToBorrows(final BorrowsDto borrowsDto) {
        return new Borrows(
                borrowsDto.getId(),
                readerDbService.getById(borrowsDto.getId()).orElse(null),
                copyDbService.getById(borrowsDto.getId()).orElse(null),
                borrowsDto.getBorrowedDate(),
                borrowsDto.getReturnedDate()
        );
    }


    public BorrowsDto mapToBorrowsDto(final Borrows borrows) {
        return new BorrowsDto(
                borrows.getId(),
                borrows.getReader().getId(),
                borrows.getCopy().getId(),
                borrows.getBorrowedDate(),
                borrows.getReturnedDate()
        );
    }

    public List<BorrowsDto> mapToBorrowsDtoList(final List<Borrows> borrowsList) {
        return borrowsList.stream()
                .map(s->mapToBorrowsDto(s))
                .collect(Collectors.toList());
    }


}
