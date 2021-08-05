package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.ProjectsDTO;
import com.darkblue97.curriculummonolith.repository.ProjectsRepository;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProjectsDAO implements DAOInterface<ProjectsDTO> {

    @Autowired
    private ProjectsRepository projectsRepository;

    @Override
    public Optional<ProjectsDTO> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<ProjectsDTO> getAll(LanguageEnum languageEnum) {
        return null;
    }

    @Override
    public void save(ProjectsDTO projectsDTO) {

    }

    @Override
    public void update(ProjectsDTO projectsDTO) {

    }

    @Override
    public void delete(ProjectsDTO projectsDTO) {

    }
}
