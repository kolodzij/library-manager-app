package com.crudapi.library.mapper;

import com.crudapi.library.domain.Title;
import com.crudapi.library.domain.TitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {

    public Title mapToTitle(final TitleDto titleDto) {
        return new Title(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getPublishedDate()
        );
    }

    public TitleDto mapToTitleDto(final Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublishedDate()
        );
    }

    public List<TitleDto> mapToTitleDtoList(final List<Title> titleList) {
        return titleList.stream()
                .map(s->new TitleDto(s.getId(),s.getTitle(),s.getAuthor(),s.getPublishedDate()))
                .collect(Collectors.toList());
    }
}
