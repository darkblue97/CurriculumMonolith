package com.darkblue97.curriculummonolith.domain;

import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Document(value = "JobExperience")
@AllArgsConstructor
public class Jobs {
    @Id
    private UUID id;
    private String companyName;
    private LocalDateTime started;
    private LocalDateTime ended;
    private boolean actual = false;
    private String description;
    private List<Technologies> technologies;
    private LanguageEnum languageCode;

}
