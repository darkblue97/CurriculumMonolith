package com.darkblue97.curriculummonolith.domain.dto;

import com.darkblue97.curriculummonolith.domain.Projects;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectsDTO {

    private String projectName;
    private String description;
    private String url;
    private LocalDateTime started;
    private LocalDateTime ended;
    private boolean currentlyWorking;
    private LanguageEnum languageCode;

    public ProjectsDTO(String projectName, String description, String url, LocalDateTime started, LocalDateTime ended,
                       boolean currentlyWorking, LanguageEnum languageCode) {
        this.projectName = projectName;
        this.description = description;
        this.url = url;
        this.started = started;
        this.ended = ended;
        this.currentlyWorking = currentlyWorking;
        this.languageCode = languageCode;
    }

    public static ProjectsDTO projectsDTO(Projects projects) {
        return new ProjectsDTO(projects.getProjectName(), projects.getDescription(), projects.getUrl(),
                projects.getStarted(), projects.getEnded(), projects.isCurrentlyWorking(), projects.getLanguageCode()
        );
    }
}
