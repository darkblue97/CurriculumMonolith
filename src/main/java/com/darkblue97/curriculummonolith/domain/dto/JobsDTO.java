package com.darkblue97.curriculummonolith.domain.dto;

import com.darkblue97.curriculummonolith.domain.Technologies;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class JobsDTO {

    private UUID id;
    private String companyName;
    private LocalDateTime started;
    private LocalDateTime ended;
    private boolean actual;
    private String description;
    private List<Technologies> technologies;
    private LanguageEnum languageCode;
}
