package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.Jobs;
import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.JobsDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class JobsDAO implements DAOInterface<JobsDTO> {

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
