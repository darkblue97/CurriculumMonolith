package com.darkblue97.curriculummonolith.domain.dto;

import com.darkblue97.curriculummonolith.domain.Projects;
import com.darkblue97.curriculummonolith.utils.GenerationUUID;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ProjectsDTO {

    private UUID id;
    private String projectName;
    private String description;
    private String url;
    private LocalDateTime started;
    private LocalDateTime ended;
    private boolean currentlyWorking;
    private LanguageEnum languageCode;
}
