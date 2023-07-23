package com.darkblue97.curriculummonolith.domain.dto;

import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.darkblue97.curriculummonolith.utils.MasteringLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class SkillsDTO {

    private UUID id;
    private String skillName;
    private String description;
    private MasteringLevel masteringLevel;
    private LanguageEnum languageCode;
}
