package com.darkblue97.curriculummonolith.domain.mappers;

import com.darkblue97.curriculummonolith.domain.Jobs;
import com.darkblue97.curriculummonolith.domain.dto.JobsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JobsMapper {
    JobsMapper INSTANCE = Mappers.getMapper(JobsMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "companyName"),
            @Mapping(target = "started"),
            @Mapping(target = "ended"),
            @Mapping(target = "actual"),
            @Mapping(target = "description"),
            @Mapping(target = "technologies"),
            @Mapping(target = "languageCode"),
    })
    JobsDTO toDTO(Jobs jobs);


    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "companyName"),
            @Mapping(target = "started"),
            @Mapping(target = "ended"),
            @Mapping(target = "actual"),
            @Mapping(target = "description"),
            @Mapping(target = "technologies"),
            @Mapping(target = "languageCode"),
    })
    Jobs toEntity(JobsDTO jobs);
}
