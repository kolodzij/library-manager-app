package com.crudapi.library.controller;

import com.crudapi.library.domain.*;
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

import java.time.LocalDate;
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


    @RequestMapping(method = RequestMethod.GET, value = "/getCopiesOfTitle")
    public List<CopyDto> getAllCopiesOfTitle(@RequestParam Long titleId) {
        return copyMapper.mapToCopyDtoList(copyService.getCopiesByTitle(titleId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/borrowCopy")
    public void borrowCopy(@RequestParam  Long readerId, Long copyId) throws RequestNotFoundException {
        Borrows borrow = new Borrows(null,
                readerService.getById(readerId).orElseThrow(RequestNotFoundException::new),
                copyService.getById(copyId).orElseThrow(RequestNotFoundException::new),
                LocalDate.now(),
                null
        );
        copyService.getById(copyId).orElseThrow(RequestNotFoundException::new).setStatus("BORROWED");
        borrowsService.save(borrow);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/returnCopy")
    public void returnCopy(@RequestParam Long copyId) throws RequestNotFoundException {
        borrowsService.getByCopyId(copyId).orElseThrow(RequestNotFoundException::new).setReturnedDate(LocalDate.now());
        borrowsService.save( borrowsService.getByCopyId(copyId).orElseThrow(RequestNotFoundException::new));
        copyService.getById(copyId).orElseThrow(RequestNotFoundException::new).setStatus("AVAILABLE");
        copyService.save(copyService.getById(copyId).orElseThrow(RequestNotFoundException::new));
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getAllTitles")
    public List<TitleDto> getAllTitles() {
        return titleMapper.mapToTitleDtoList(titleService.getAll());
    }

    @RequestMapping(method=RequestMethod.GET, value = "/getTitle")
    public TitleDto getTitle(@RequestParam Long id) throws RequestNotFoundException {
       return titleMapper.mapToTitleDto(titleService.getById(id).orElseThrow(RequestNotFoundException::new));
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
    public ReaderDto getReader(@RequestParam Long id) throws RequestNotFoundException {
        return readerMapper.mapToReaderDto(readerService.getById(id).orElseThrow(RequestNotFoundException::new));
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


    @RequestMapping(method = RequestMethod.GET, value = "/getAllCopies")
    public List<CopyDto> getAllCopies() {
        return copyMapper.mapToCopyDtoList(copyService.getAll());
    }

    @RequestMapping(method=RequestMethod.GET, value = "/getCopy")
    public CopyDto getCopy(@RequestParam Long id) throws RequestNotFoundException {
        return copyMapper.mapToCopyDto(copyService.getById(id).orElseThrow(RequestNotFoundException::new));
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/deleteCopy")
    public void deleteCopy(@RequestParam Long id) {
        copyService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateCopy")
    public CopyDto updateCopy(@RequestBody CopyDto copyDto) {
        return copyMapper.mapToCopyDto(copyService.save(copyMapper.mapToCopy(copyDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createCopy", consumes = APPLICATION_JSON_VALUE)
    public void createCopy(@RequestBody CopyDto copyDto) {
        copyService.save(copyMapper.mapToCopy(copyDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllBorrows")
    public List<BorrowsDto> getAllBorrows() {
        return borrowsMapper.mapToBorrowsDtoList(borrowsService.getAll());
    }
}
