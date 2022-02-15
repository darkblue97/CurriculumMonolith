package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.Projects;
import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.AboutDTO;
import com.darkblue97.curriculummonolith.domain.dto.ProjectsDTO;
import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.repository.ProjectsRepository;
import com.darkblue97.curriculummonolith.utils.GenerationUUID;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Component
public class ProjectsDAO implements DAOInterface<ProjectsDTO> {

    private final ProjectsRepository projectsRepository;

    public ProjectsDAO(ProjectsRepository getProjectsRepository) {
        this.projectsRepository = getProjectsRepository;
    }

    @Override
    public Optional<ProjectsDTO> get(UUID id) {
        return projectsRepository.findById(id).map(ProjectsDTO::toDTO);
    }

    public Optional<ProjectsDTO> get(LanguageEnum id) {
        return projectsRepository.findByLanguageCode(id).map(ProjectsDTO::toDTO);
    }

    @Override
    public List<ProjectsDTO> getAll(LanguageEnum languageEnum) {
        List<ProjectsDTO> projectsDTOS = new ArrayList<>();
        projectsRepository.findAllByLanguageCode(languageEnum).iterator().forEachRemaining(k -> projectsDTOS.add(ProjectsDTO.toDTO(k)));
        return projectsDTOS;
    }

    @Override
    @Transactional
    public void save(ProjectsDTO projectsDTO) throws DataAlreadySavedException {
        if (!getAllByLanguageCode(projectsDTO.getLanguageCode()).isEmpty()) {
            throw new DataAlreadySavedException("Data already saved with this language code");
        }

        projectsDTO.setId(GenerationUUID.generate());
        projectsRepository.save(ProjectsDTO.toModel(projectsDTO));
    }

    @Override
    @Transactional
    public void update(ProjectsDTO projectsDTO) throws NotFoundException {
        ProjectsDTO projectToUpdate = get(projectsDTO.getId()).orElseThrow(() -> new NotFoundException("Data not found"));
        projectToUpdate.setProjectName(projectsDTO.getProjectName());
        projectToUpdate.setDescription(projectsDTO.getDescription());
        projectToUpdate.setEnded(projectsDTO.getEnded());
        projectToUpdate.setStarted(projectsDTO.getStarted());
        projectToUpdate.setCurrentlyWorking(projectsDTO.isCurrentlyWorking());
        projectToUpdate.setLanguageCode(projectsDTO.getLanguageCode());
        projectToUpdate.setUrl(projectsDTO.getUrl());

        projectsRepository.save(ProjectsDTO.toModel(projectToUpdate));
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        ProjectsDTO projectsDTO = get(id).orElseThrow(() -> new NotFoundException("Data not found"));
        Projects projects = ProjectsDTO.toModel(projectsDTO);
        projectsRepository.delete(projects);
    }

    public List<ProjectsDTO> getAllByLanguageCode(LanguageEnum languageEnum) {
        List<ProjectsDTO> projectsDTOS = new ArrayList<>();
        projectsRepository.findAllByLanguageCode(languageEnum).iterator().forEachRemaining(k -> projectsDTOS.add(ProjectsDTO.toDTO(k)));
        return projectsDTOS;
    }
}
