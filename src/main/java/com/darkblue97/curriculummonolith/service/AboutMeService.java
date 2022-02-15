package com.darkblue97.curriculummonolith.service;

import com.darkblue97.curriculummonolith.domain.dto.AboutDTO;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;

public interface AboutMeService extends CommonMethods<LanguageEnum, AboutDTO> {

    AboutDTO getAboutMeInformation(LanguageEnum languageEnum) throws NotFoundException;
}
