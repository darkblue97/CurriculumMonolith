package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.LanguagesDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LanguageDAO implements DAOInterface<LanguagesDTO> {
    @Override
    public Optional<LanguagesDTO> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<LanguagesDTO> getAll() {
        return null;
    }

    @Override
    public void save(LanguagesDTO languagesDTO) {

    }

    @Override
    public void update(LanguagesDTO languagesDTO, String[] params) {

    }

    @Override
    public void delete(LanguagesDTO languagesDTO) {

    }
}
