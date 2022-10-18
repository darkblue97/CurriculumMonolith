package com.darkblue97.curriculummonolith.domain.dto;

import com.darkblue97.curriculummonolith.domain.Skills;
import com.darkblue97.curriculummonolith.utils.GenerationUUID;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.darkblue97.curriculummonolith.utils.MasteringLevel;
import lombok.Data;

import java.util.UUID;

@Data
public class SkillsDTO {

    private UUID id;
    private String skillName;
    private String description;
    private MasteringLevel masteringLevel;
    private LanguageEnum languageCode;

    public SkillsDTO(UUID id, String skillName, String description, MasteringLevel masteringLevel, LanguageEnum languageCode) {
        this.id = id;
        this.skillName = skillName;
        this.description = description;
        this.masteringLevel = masteringLevel;
        this.languageCode = languageCode;
    }

    public static SkillsDTO toDto(Skills skills) {
        return new SkillsDTO(
                skills.getId(),
                skills.getSkillName(),
                skills.getSkillName(),
                skills.getMasteringLevel(),
                skills.getLanguageCode()
        );
    }

    public static Skills toModel(SkillsDTO skillsDTO) {
        return new Skills(
                GenerationUUID.generate(),
                skillsDTO.getSkillName(),
                skillsDTO.getDescription(),
                skillsDTO.getMasteringLevel(),
                skillsDTO.getLanguageCode()
        );
    }
}
