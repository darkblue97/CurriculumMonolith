package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.Jobs;
import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.JobsDTO;
import com.darkblue97.curriculummonolith.domain.mappers.JobsMapper;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.repository.ExperienceRepository;
import com.darkblue97.curriculummonolith.utils.GenerationUUID;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Component
public class JobsDAO implements DAOInterface<JobsDTO> {

    private final ExperienceRepository experienceRepository;

    public JobsDAO(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public Optional<JobsDTO> get(UUID id) {
        return experienceRepository.findById(id).map(JobsMapper.INSTANCE::toDTO);
    }

    @Override
    public List<JobsDTO> getAll(LanguageEnum languageEnum) throws NotFoundException {
        List<JobsDTO> jobsDTOS = new ArrayList<>();
        experienceRepository.findAllByLanguageCode(languageEnum).forEach(k -> jobsDTOS.add(JobsMapper.INSTANCE.toDTO(k)));

        if (jobsDTOS.isEmpty()) {
            throw new NotFoundException("Jobs not found");
        }

        return jobsDTOS;
    }

    @Override
    public void save(JobsDTO jobsDTO) {
        Jobs jobs = JobsMapper.INSTANCE.toEntity(jobsDTO);
        jobs.setId(GenerationUUID.generate());
        experienceRepository.save(jobs);
    }

    @Override
    public void update(JobsDTO jobsDTO) throws NotFoundException {
        JobsDTO toUpdate = get(jobsDTO.getId()).orElseThrow(
                () -> new NotFoundException("Job experience with that UUID is not found database")
        );

        toUpdate.setCompanyName(jobsDTO.getCompanyName());
        toUpdate.setDescription(jobsDTO.getDescription());
        toUpdate.setStarted(jobsDTO.getStarted());
        toUpdate.setEnded(jobsDTO.getEnded());
        toUpdate.setTechnologies(jobsDTO.getTechnologies());
        toUpdate.setActual(jobsDTO.isActual());
        toUpdate.setLanguageCode(jobsDTO.getLanguageCode());

        experienceRepository.save(JobsMapper.INSTANCE.toEntity(toUpdate));
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        JobsDTO toDelete = get(id).orElseThrow(
                () -> new NotFoundException("Job experience with that UUID is not found database")
        );

        experienceRepository.delete(JobsMapper.INSTANCE.toEntity(toDelete));
    }
}
