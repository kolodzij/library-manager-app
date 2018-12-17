package com.crudapi.library.controller;

import com.crudapi.library.domain.ReaderDto;
import com.crudapi.library.domain.TitleDto;
import com.crudapi.library.mapper.BorrowsMapper;
import com.crudapi.library.mapper.CopyMapper;
import com.crudapi.library.mapper.ReaderMapper;
import com.crudapi.library.mapper.TitleMapper;
import com.crudapi.library.service.BorrowsDbService;
import com.crudapi.library.service.CopyDbService;
import com.crudapi.library.service.ReaderDbService;
import com.crudapi.library.service.TitleDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    @Autowired
    private TitleDbService titleService;
    @Autowired
    private TitleMapper titleMapper;

    @Autowired
    private ReaderDbService readerService;
    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private CopyDbService copyService;
    @Autowired
    private CopyMapper copyMapper;

    @Autowired
    private BorrowsDbService borrowsService;
    @Autowired
    private BorrowsMapper borrowsMapper;


    @RequestMapping(method = RequestMethod.GET, value = "/getAllTitles")
    public List<TitleDto> getAllTitles() {
        return titleMapper.mapToTitleDtoList(titleService.getAll());
    }

    @RequestMapping(method=RequestMethod.GET, value = "/getTitle")
    public TitleDto getTitle(@RequestParam Long id) throws TitleNotFoundException {
       return titleMapper.mapToTitleDto(titleService.getById(id).orElseThrow(TitleNotFoundException::new));
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/deleteTitle")
    public void deleteTitle(@RequestParam Long id) {
        titleService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateTitle")
    public TitleDto updateTitle(@RequestBody TitleDto titleDto) {
        return titleMapper.mapToTitleDto(titleService.save(titleMapper.mapToTitle(titleDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createTitle", consumes = APPLICATION_JSON_VALUE)
    public void createTitle(@RequestBody TitleDto titleDto) {
         titleService.save(titleMapper.mapToTitle(titleDto));
    }



    @RequestMapping(method = RequestMethod.GET, value = "/getAllReaders")
    public List<ReaderDto> getAllReaders() {
        return readerMapper.mapToReaderDtoList(readerService.getAll());
    }

    @RequestMapping(method=RequestMethod.GET, value = "/getReader")
    public ReaderDto getReader(@RequestParam Long id) throws ReaderNotFoundException {
        return readerMapper.mapToReaderDto(readerService.getById(id).orElseThrow(ReaderNotFoundException::new));
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/deleteReader")
    public void deleteReader(@RequestParam Long id) {
        readerService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateReader")
    public ReaderDto updateReader(@RequestBody ReaderDto readerDto) {
        return readerMapper.mapToReaderDto(readerService.save(readerMapper.mapToReader(readerDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createReader", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        readerService.save(readerMapper.mapToReader(readerDto));
    }



}
