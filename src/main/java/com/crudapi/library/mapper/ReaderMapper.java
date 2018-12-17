package com.crudapi.library.mapper;

import com.crudapi.library.domain.Reader;
import com.crudapi.library.domain.ReaderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getName(),
                readerDto.getJoinedDate()
        );
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getName(),
                reader.getJoinedDate()
        );
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList) {
        return readerList.stream()
                    .map(s->mapToReaderDto(s))
                    .collect(Collectors.toList());
    }

}
