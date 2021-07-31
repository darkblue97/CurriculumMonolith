package com.darkblue97.curriculummonolith.domain.dto;

import com.darkblue97.curriculummonolith.domain.Skills;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.darkblue97.curriculummonolith.utils.MasteringLevel;
import lombok.Data;

@Data
public class SkillsDTO {

    private String skillName;
    private String description;
    private MasteringLevel masteringLevel;
    private LanguageEnum languageCode;

    public SkillsDTO(String skillName, String description, MasteringLevel masteringLevel, LanguageEnum languageCode) {
        this.skillName = skillName;
        this.description = description;
        this.masteringLevel = masteringLevel;
        this.languageCode = languageCode;
    }

    public static SkillsDTO toDto(Skills skills) {
        return new SkillsDTO(skills.getSkillName(), skills.getSkillName(),
                skills.getMasteringLevel(), skills.getLanguageCode()
        );
    }
}
