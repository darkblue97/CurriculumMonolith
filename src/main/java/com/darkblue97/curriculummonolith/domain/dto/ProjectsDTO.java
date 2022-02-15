package com.darkblue97.curriculummonolith.domain.dto;

import com.darkblue97.curriculummonolith.domain.Projects;
import com.darkblue97.curriculummonolith.utils.GenerationUUID;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class ProjectsDTO {

    private UUID id;
    private String projectName;
    private String description;
    private String url;
    private LocalDateTime started;
    private LocalDateTime ended;
    private boolean currentlyWorking;
    private LanguageEnum languageCode;

    public ProjectsDTO(UUID id, String projectName, String description, String url, LocalDateTime started, LocalDateTime ended,
                       boolean currentlyWorking, LanguageEnum languageCode) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.url = url;
        this.started = started;
        this.ended = ended;
        this.currentlyWorking = currentlyWorking;
        this.languageCode = languageCode;
    }

    public static ProjectsDTO toDTO(Projects projects) {
        return new ProjectsDTO(
                projects.getId(),
                projects.getProjectName(),
                projects.getDescription(),
                projects.getUrl(),
                projects.getStarted(),
                projects.getEnded(),
                projects.isCurrentlyWorking(),
                projects.getLanguageCode()
        );
    }

    public static Projects toModel(ProjectsDTO projectsDTO) {
        return new Projects(
                GenerationUUID.generate(),
                projectsDTO.getProjectName(),
                projectsDTO.getDescription(),
                projectsDTO.getUrl(),
                projectsDTO.getStarted(),
                projectsDTO.getEnded(),
                projectsDTO.isCurrentlyWorking(),
                projectsDTO.getLanguageCode()
        );
    }
}
