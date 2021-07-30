package com.darkblue97.curriculummonolith.domain;

import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Projects {

    @Id
    private UUID id;
    private String projectName;
    private String description;
    private String url;
    private LanguageEnum languageCode;

    public Projects(UUID id, String projectName, String description, String url) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.url = url;
    }
}
