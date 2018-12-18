package com.crudapi.library.mapper;

import com.crudapi.library.domain.Copy;
import com.crudapi.library.domain.CopyDto;
import com.crudapi.library.service.TitleDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CopyMapper {

    @Autowired
    private TitleDbService titleDbService;

    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
                copyDto.getId(),
                titleDbService.getById(copyDto.getTitleId()).orElse(null),
                copyDto.getStatus()
        );
    }


    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getTitle().getId(),
                copy.getStatus()
        );
    }

    public List<CopyDto> mapToCopyDtoList(final List<Copy> copyList) {
        return copyList.stream()
                .map(s->mapToCopyDto(s))
                .collect(Collectors.toList());
    }

}
