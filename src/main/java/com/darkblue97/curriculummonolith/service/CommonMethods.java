package com.darkblue97.curriculummonolith.service;

import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface CommonMethods<T, V> {
    List<V> getAll(T t) throws NotFoundException;

    void putObject(V v) throws DataAlreadySavedException;

    void postObject(V v) throws NotFoundException;

    void deleteObject(UUID id) throws NotFoundException;
}
