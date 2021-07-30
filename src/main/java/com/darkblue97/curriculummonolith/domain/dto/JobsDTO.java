package com.darkblue97.curriculummonolith.domain.dto;

import com.darkblue97.curriculummonolith.domain.Jobs;
import com.darkblue97.curriculummonolith.domain.Technologies;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class JobsDTO {

    private String companyName;
    private LocalDateTime started;
    private LocalDateTime ended;
    private boolean actual = false;
    private String description;
    private List<Technologies> technologies;
    private LanguageEnum languageCode;

    public JobsDTO(String companyName, LocalDateTime started, LocalDateTime ended, boolean actual, String description, List<Technologies> technologies, LanguageEnum languageCode) {
        this.companyName = companyName;
        this.started = started;
        this.ended = ended;
        this.actual = actual;
        this.description = description;
        this.technologies = technologies;
        this.languageCode = languageCode;
    }

    public static JobsDTO toDto(Jobs jobs) {
        return new JobsDTO(jobs.getCompanyName(), jobs.getStarted(), jobs.getEnded(),
                jobs.isActual(), jobs.getDescription(), jobs.getTechnologies(), jobs.getLanguageCode()
        );
    }
}
