package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.JobsDTO;
import com.darkblue97.curriculummonolith.repository.ExperienceRepository;
import com.darkblue97.curriculummonolith.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class JobsDAO implements DAOInterface<JobsDTO> {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public Optional<JobsDTO> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<JobsDTO> getAll() {
        return null;
    }

    @Override
    public void save(JobsDTO jobsDTO) {

    }

    @Override
    public void update(JobsDTO jobsDTO, String[] params) {

    }

    @Override
    public void delete(JobsDTO jobsDTO) {

    }
}
