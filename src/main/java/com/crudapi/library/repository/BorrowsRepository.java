package com.crudapi.library.repository;

import com.crudapi.library.domain.Borrows;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowsRepository extends CrudRepository<Borrows, Long> {

    @Override
    Borrows save(Borrows borrows);

    @Override
    Optional<Borrows> findById(Long id);

    @Override
    List<Borrows> findAll();

    @Override
    void deleteById(Long id);
}
