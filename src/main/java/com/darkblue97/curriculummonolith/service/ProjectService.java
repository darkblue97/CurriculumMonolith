package com.darkblue97.curriculummonolith.service;

import com.darkblue97.curriculummonolith.domain.dto.ProjectsDTO;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;

public interface ProjectService extends CommonMethods<LanguageEnum, ProjectsDTO> {
    ProjectsDTO getProjectInformation(LanguageEnum languageEnum) throws NotFoundException;
}
