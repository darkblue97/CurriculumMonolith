package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.LanguagesDTO;
import com.darkblue97.curriculummonolith.repository.LanguagesRepository;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LanguageDAO implements DAOInterface<LanguagesDTO> {

    @Autowired
    private LanguagesRepository languagesRepository;

    @Override
    public Optional<LanguagesDTO> get(LanguageEnum languageEnum) {
        return Optional.empty();
    }

    @Override
    public Optional<LanguagesDTO> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<LanguagesDTO> getAll(LanguageEnum languageEnum) {
        return null;
    }

    @Override
    public void save(LanguagesDTO languagesDTO) {

    }

    @Override
    public void update(LanguagesDTO languagesDTO) {

    }

    @Override
    public void delete(LanguagesDTO languagesDTO) {

    }
}
