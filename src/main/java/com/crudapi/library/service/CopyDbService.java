package com.crudapi.library.service;

import com.crudapi.library.domain.Copy;
import com.crudapi.library.domain.Title;
import com.crudapi.library.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CopyDbService {

    @Autowired
    private CopyRepository copyRepository;

    public List<Copy> getAll() {
        return copyRepository.findAll();
    }

    public Optional<Copy> getById(final Long id) {
        return copyRepository.findById(id);
    }

    public void delete(final Long id) {
        copyRepository.deleteById(id);
    }

    public Copy save(final Copy copy) {
        return copyRepository.save(copy);
    }

    public List<Copy> getCopiesByTitle(Long id) {
        return copyRepository.findAllByTitleId(id);
    }


}
