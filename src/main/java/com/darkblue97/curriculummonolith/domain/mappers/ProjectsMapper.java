package com.darkblue97.curriculummonolith.domain.mappers;

import com.darkblue97.curriculummonolith.domain.Projects;
import com.darkblue97.curriculummonolith.domain.dto.ProjectsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectsMapper {

    ProjectsMapper INSTANCE = Mappers.getMapper(ProjectsMapper.class);

    @Mappings({
            @Mapping(target = "id"),
            @Mapping(target = "projectName"),
            @Mapping(target = "description"),
            @Mapping(target = "url"),
            @Mapping(target = "started"),
            @Mapping(target = "ended"),
            @Mapping(target = "currentlyWorking"),
            @Mapping(target = "languageCode"),
    })
    ProjectsDTO toDTO(Projects projects);


    @Mappings({
            @Mapping(target = "id"),
            @Mapping(target = "projectName"),
            @Mapping(target = "description"),
            @Mapping(target = "url"),
            @Mapping(target = "started"),
            @Mapping(target = "ended"),
            @Mapping(target = "currentlyWorking"),
            @Mapping(target = "languageCode"),
    })
    Projects toEntity(ProjectsDTO projects);

}
