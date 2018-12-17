package com.crudapi.library.service;

import com.crudapi.library.domain.Title;
import com.crudapi.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitleDbService {

    @Autowired
    private TitleRepository titleRepository;

    public List<Title> getAll() {
        return titleRepository.findAll();
    }

    public Optional<Title> getById(Long id) {
        return titleRepository.findById(id);
    }

    public void delete(Long id) {
        titleRepository.deleteById(id);
    }

    public Title save(Title title) {
        return titleRepository.save(title);
    }

}
