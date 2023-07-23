package com.darkblue97.curriculummonolith.domain.mappers;

import com.darkblue97.curriculummonolith.domain.AboutMe;
import com.darkblue97.curriculummonolith.domain.dto.AboutDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AboutMapper {
    AboutMapper INSTANCE = Mappers.getMapper(AboutMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "title"),
            @Mapping(target = "text"),
            @Mapping(target = "mediaId"),
            @Mapping(target = "languageCode"),
    })
    AboutDTO toDTO(AboutMe aboutMe);


    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "title"),
            @Mapping(target = "text"),
            @Mapping(target = "mediaId"),
            @Mapping(target = "languageCode")
    })
    AboutMe toEntity(AboutDTO aboutDTO);

}
