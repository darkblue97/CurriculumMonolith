package com.darkblue97.curriculummonolith.service;

import com.darkblue97.curriculummonolith.domain.dto.AboutDTO;
import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;

import java.util.UUID;

public interface AboutMeService {

    AboutDTO getAboutMeInformation(LanguageEnum languageEnum) throws NotFoundException;

    void postAboutMeInformation(AboutDTO aboutDTO) throws NotFoundException;

    void putAboutMeInformation(AboutDTO aboutDTO) throws DataAlreadySavedException;

    void deleteAboutMeInformation(UUID id) throws NotFoundException;
}
