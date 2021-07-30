package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.ProjectsDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProjectsDAO implements DAOInterface<ProjectsDTO> {
    @Override
    public Optional<ProjectsDTO> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<ProjectsDTO> getAll() {
        return null;
    }

    @Override
    public void save(ProjectsDTO projectsDTO) {

    }

    @Override
    public void update(ProjectsDTO projectsDTO, String[] params) {

    }

    @Override
    public void delete(ProjectsDTO projectsDTO) {

    }
}
