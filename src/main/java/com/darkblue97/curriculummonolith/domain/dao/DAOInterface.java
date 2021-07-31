package com.darkblue97.curriculummonolith.domain.dao;

import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DAOInterface<T> {


    Optional<T> get(LanguageEnum languageEnum);

    Optional<T> get(UUID id);

    List<T> getAll();

    void save(T t) throws DataAlreadySavedException;

    void update(T t, String[] params);

    void delete(T t);
}
