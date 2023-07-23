package com.darkblue97.curriculummonolith.service.impl;

import com.darkblue97.curriculummonolith.domain.dao.impl.ProjectsDAO;
import com.darkblue97.curriculummonolith.domain.dto.ProjectsDTO;
import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.service.ProjectService;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Component
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectsDAO projectsDAO;

    public ProjectServiceImpl(ProjectsDAO projectsDAO) {
        this.projectsDAO = projectsDAO;
    }

    @Override
    public List<ProjectsDTO> getAll(LanguageEnum languageEnum) throws NotFoundException {
        return null;
    }

    @Override
    public void putObject(ProjectsDTO projectsDTO) throws DataAlreadySavedException, NotFoundException {
        projectsDAO.update(projectsDTO);
    }

    @Override
    public void postObject(ProjectsDTO projectsDTO) throws NotFoundException, DataAlreadySavedException {
        projectsDAO.save(projectsDTO);
    }

    @Override
    public void deleteObject(UUID id) throws NotFoundException {
        projectsDAO.delete(id);
    }

    @Override
    public ProjectsDTO getProjectInformation(LanguageEnum languageEnum) throws NotFoundException {
        return projectsDAO.get(languageEnum).orElseThrow(() -> new NotFoundException("Data not found"));
    }
}
