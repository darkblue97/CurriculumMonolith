package com.darkblue97.curriculummonolith.domain;

import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.darkblue97.curriculummonolith.utils.MasteringLevel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(value = "Technologies")
public class Technologies {

    @Id
    private UUID id;
    private String description;
    private String technologyName;
    private MasteringLevel mastering;
    private LanguageEnum languageCode;

    public Technologies(UUID id, String description, String technologyName, MasteringLevel mastering, LanguageEnum languageCode) {
        this.id = id;
        this.description = description;
        this.technologyName = technologyName;
        this.mastering = mastering;
        this.languageCode = languageCode;
    }
}
