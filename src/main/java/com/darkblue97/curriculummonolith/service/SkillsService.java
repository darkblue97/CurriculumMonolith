package com.darkblue97.curriculummonolith.service;

import com.darkblue97.curriculummonolith.domain.dto.SkillsDTO;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;

public interface SkillsService extends CommonMethods<LanguageEnum, SkillsDTO> {

    SkillsDTO getSkillInformation(LanguageEnum language) throws NotFoundException;
}
