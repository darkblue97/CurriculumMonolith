package com.darkblue97.curriculummonolith.domain.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DAOInterface<T> {

    Optional<T> get(UUID id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
