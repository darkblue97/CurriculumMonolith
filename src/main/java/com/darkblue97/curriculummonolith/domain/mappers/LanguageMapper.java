package com.darkblue97.curriculummonolith.domain.mappers;

import com.darkblue97.curriculummonolith.domain.Languages;
import com.darkblue97.curriculummonolith.domain.dto.LanguagesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageMapper {

    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "language"),
            @Mapping(target = "read"),
            @Mapping(target = "speak"),
            @Mapping(target = "listen"),
            @Mapping(target = "languageCode"),
    })
    LanguagesDTO toDTO(Languages languages);


    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "language"),
            @Mapping(target = "read"),
            @Mapping(target = "speak"),
            @Mapping(target = "listen"),
            @Mapping(target = "languageCode"),
    })
    Languages toEntity(LanguagesDTO languages);
}
