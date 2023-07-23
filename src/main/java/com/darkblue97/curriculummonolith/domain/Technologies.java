package com.darkblue97.curriculummonolith.domain;

import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.darkblue97.curriculummonolith.utils.MasteringLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(value = "Technologies")
@AllArgsConstructor
public class Technologies {

    @Id
    private UUID id;
    private String description;
    private String technologyName;
    private MasteringLevel mastering;
    private LanguageEnum languageCode;

}
