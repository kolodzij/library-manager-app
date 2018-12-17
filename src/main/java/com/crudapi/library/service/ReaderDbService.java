package com.crudapi.library.service;

import com.crudapi.library.domain.Reader;
import com.crudapi.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderDbService {

    @Autowired
    private ReaderRepository readerRepository;

    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    public Optional<Reader> getById(final Long id) {
        return readerRepository.findById(id);
    }

    public void delete(final Long id) {
        readerRepository.deleteById(id);
    }

    public Reader save(final Reader reader) {
        return readerRepository.save(reader);
    }
}
