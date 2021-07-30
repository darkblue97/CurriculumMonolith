package com.darkblue97.curriculummonolith.domain;

import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.darkblue97.curriculummonolith.utils.MasteringLevel;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Technologies {

    @Id
    private UUID id;
    private String technologyName;
    private MasteringLevel mastering;
    private LanguageEnum languageCode;

    public Technologies(UUID id, String technologyName, MasteringLevel mastering) {
        this.id = id;
        this.technologyName = technologyName;
        this.mastering = mastering;
    }
}
