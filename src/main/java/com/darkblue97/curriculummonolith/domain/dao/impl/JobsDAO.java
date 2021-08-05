package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.JobsDTO;
import com.darkblue97.curriculummonolith.repository.ExperienceRepository;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Component
public class JobsDAO implements DAOInterface<JobsDTO> {

    private final ExperienceRepository experienceRepository;

    public JobsDAO(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public Optional<JobsDTO> get(LanguageEnum languageEnum) {
        return Optional.empty();
    }

    @Override
    public Optional<JobsDTO> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<JobsDTO> getAll(LanguageEnum languageEnum) {
        List<JobsDTO> jobsDTOS = new ArrayList<>();
        experienceRepository.findAllByLanguageCode(languageEnum).forEach(k -> jobsDTOS.add(JobsDTO.toDto(k)));
        return jobsDTOS;
    }

    @Override
    public void save(JobsDTO jobsDTO) {

    }

    @Override
    public void update(JobsDTO jobsDTO) {

    }

    @Override
    public void delete(JobsDTO jobsDTO) {

    }
}
