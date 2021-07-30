package com.darkblue97.curriculummonolith.domain;

import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document(value = "Projects")
public class Projects {

    @Id
    private UUID id;
    private String projectName;
    private String description;
    private String url;
    private LocalDateTime started;
    private LocalDateTime ended;
    private boolean currentlyWorking;
    private LanguageEnum languageCode;

    public Projects(UUID id, String projectName, String description, String url,
                    LocalDateTime started, LocalDateTime ended, boolean currentlyWorking, LanguageEnum languageCode) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.url = url;
        this.started = started;
        this.ended = ended;
        this.currentlyWorking = currentlyWorking;
        this.languageCode = languageCode;
    }
}
