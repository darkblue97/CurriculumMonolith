package com.darkblue97.curriculummonolith.domain;

import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.darkblue97.curriculummonolith.utils.MasteringLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(value = "Skills")
@AllArgsConstructor
public class Skills {

    @Id
    private UUID id;
    private String skillName;
    private String description;
    private MasteringLevel masteringLevel;
    private LanguageEnum languageCode;

}
