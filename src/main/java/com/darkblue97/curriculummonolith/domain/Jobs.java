package com.darkblue97.curriculummonolith.domain;

import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Jobs {
    @Id
    private UUID id;
    private String companyName;
    private LocalDate started;
    private LocalDateTime ended;
    private boolean actual = false;
    private String description;
    private List<Technologies> technologies;
    private LanguageEnum languageCode;

    public Jobs(UUID id, String companyName, LocalDate started, LocalDateTime ended, boolean actual, String description, List<Technologies> technologies) {
        this.id = id;
        this.companyName = companyName;
        this.started = started;
        this.ended = ended;
        this.actual = actual;
        this.description = description;
        this.technologies = technologies;
    }
}
