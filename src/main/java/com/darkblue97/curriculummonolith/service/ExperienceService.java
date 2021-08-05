package com.darkblue97.curriculummonolith.service;

import com.darkblue97.curriculummonolith.domain.dto.JobsDTO;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;

import java.util.List;

public interface ExperienceService {

    List<JobsDTO> getAllExperience(LanguageEnum languageEnum) throws NotFoundException;

    void putExperience(JobsDTO jobsDTO);

    void postExperience(JobsDTO jobsDTO) throws NotFoundException;

    void deleteExperience(JobsDTO jobsDTO) throws NotFoundException;
}
