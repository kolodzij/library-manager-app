package com.crudapi.library.controller;

import com.crudapi.library.domain.Title;
import com.crudapi.library.domain.TitleDto;
import com.crudapi.library.mapper.TitleMapper;
import com.crudapi.library.service.TitleDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.http.MediaType;

@RunWith(SpringRunner.class)
@WebMvcTest(LibraryController.class)
public class LibraryControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TitleDbService titleService;
//
//    @MockBean
//    private TitleMapper titleMapper;

    @Test
    public void shouldGetTitles() throws Exception {
//
//        //Given
//        List<Title> titleList = new ArrayList<>();
//        titleList.add(new Title((long)1, "TitleTest1", "Contenet1", LocalDate.parse("2018-03-27")));
//
//        List<TitleDto> titleDtoList = new ArrayList<>();
//        titleDtoList.add(new TitleDto((long)1, "TitleTest1", "Contenet1", LocalDate.parse("2018-03-27")));
//
//        when(titleService.getAll()).thenReturn(titleList);
//        when(titleMapper.mapToTitleDtoList(titleList)).thenReturn(titleDtoList);
//
//        //When & Then
//        mockMvc.perform(get("/v1/library").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[0].title", is("TitleTest1")))
//                .andExpect(jsonPath("$[0].author", is("Contenet1")))
//                .andExpect(jsonPath("$[0].publishedDate", is(2018-03-27)));
    }

}