package com.crudapi.library.repository;

import com.crudapi.library.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TitleRepository extends CrudRepository<Title, Long> {
    @Override
    Title save(Title title);

    @Override
    Optional<Title> findById(Long id);

    @Override
    List<Title> findAll();

    @Override
    void deleteById(Long id);
}
