package com.darkblue97.curriculummonolith.service.impl;

import com.darkblue97.curriculummonolith.domain.dao.impl.LanguageDAO;
import com.darkblue97.curriculummonolith.domain.dto.LanguagesDTO;
import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.service.LanguageService;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Component
@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageDAO languageDAO;

    public LanguageServiceImpl(LanguageDAO languageDAO) {
        this.languageDAO = languageDAO;
    }

    @Override
    public List<LanguagesDTO> getAll(LanguageEnum languageEnum) throws NotFoundException {
        return null;
    }

    @Override
    public void putObject(LanguagesDTO languagesDTO) throws DataAlreadySavedException {
        languageDAO.save(languagesDTO);
    }

    @Override
    public void postObject(LanguagesDTO languagesDTO) throws NotFoundException {
        languageDAO.update(languagesDTO);
    }

    @Override
    public void deleteObject(UUID id) throws NotFoundException {
        languageDAO.delete(id);
    }
}
