package com.crudapi.library.service;

import com.crudapi.library.domain.Borrows;
import com.crudapi.library.repository.BorrowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowsDbService {

    @Autowired
    private BorrowsRepository borrowsRepository;

    public List<Borrows> getAll() {
        return borrowsRepository.findAll();
    }

    public Optional<Borrows> getById(final Long id) {
        return borrowsRepository.findById(id);
    }

    public void delete(final Long id) {
        borrowsRepository.deleteById(id);
    }

    public Borrows save(final Borrows borrows) {
        return borrowsRepository.save(borrows);
    }
}

