package com.darkblue97.curriculummonolith.domain.mappers;

import com.darkblue97.curriculummonolith.domain.Skills;
import com.darkblue97.curriculummonolith.domain.dto.SkillsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SkillsMapper {

    SkillsMapper INSTANCE = Mappers.getMapper(SkillsMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "skillName"),
            @Mapping(target = "description"),
            @Mapping(target = "masteringLevel"),
            @Mapping(target = "languageCode"),
    })
    SkillsDTO toDTO(Skills skills);


    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "skillName"),
            @Mapping(target = "description"),
            @Mapping(target = "masteringLevel"),
            @Mapping(target = "languageCode"),
    })
    Skills toEntity(SkillsDTO skills);
}
