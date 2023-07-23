package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.Skills;
import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.SkillsDTO;
import com.darkblue97.curriculummonolith.domain.mappers.SkillsMapper;
import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.repository.SkillsRepository;
import com.darkblue97.curriculummonolith.utils.GenerationUUID;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Component
public class SkillsDAO implements DAOInterface<SkillsDTO> {

    private final SkillsRepository skillsRepository;

    public SkillsDAO(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    @Override
    public Optional<SkillsDTO> get(UUID id) {
        return skillsRepository.findById(id).map(SkillsMapper.INSTANCE::toDTO);
    }

    public Optional<SkillsDTO> get(LanguageEnum languageEnum) {
        return skillsRepository.findByLanguageCode(languageEnum).map(SkillsMapper.INSTANCE::toDTO);
    }

    @Override
    public List<SkillsDTO> getAll(LanguageEnum languageEnum) {
        List<SkillsDTO> skillsDTOS = new ArrayList<>();
        skillsRepository.findAllByLanguageCode(languageEnum).iterator().forEachRemaining(
                k -> skillsDTOS.add(SkillsMapper.INSTANCE.toDTO(k))
        );

        return skillsDTOS;
    }

    @Override
    @Transactional
    public void save(SkillsDTO skillsDTO) throws DataAlreadySavedException {
        if (!getAllByLanguageCode(skillsDTO.getLanguageCode()).isEmpty()) {
            throw new DataAlreadySavedException("Data already saved with this language code");
        }

        skillsDTO.setId(GenerationUUID.generate());
        skillsRepository.save(SkillsMapper.INSTANCE.toEntity(skillsDTO));
    }

    @Override
    @Transactional
    public void update(SkillsDTO skillsDTO) throws NotFoundException {
        SkillsDTO skillsToUpdate = get(skillsDTO.getId()).orElseThrow(() -> new NotFoundException("Data not found"));
        skillsToUpdate.setSkillName(skillsDTO.getSkillName());
        skillsToUpdate.setDescription(skillsDTO.getDescription());
        skillsToUpdate.setMasteringLevel(skillsDTO.getMasteringLevel());
        skillsToUpdate.setLanguageCode(skillsDTO.getLanguageCode());

        skillsRepository.save(SkillsMapper.INSTANCE.toEntity(skillsToUpdate));
    }

    @Override
    @Transactional
    public void delete(UUID id) throws NotFoundException {
        SkillsDTO skillsDTO = get(id).orElseThrow(() -> new NotFoundException("Data not found"));
        Skills skills = SkillsMapper.INSTANCE.toEntity(skillsDTO);
        skillsRepository.delete(skills);
    }

    public List<SkillsDTO> getAllByLanguageCode(LanguageEnum languageEnum) {
        List<SkillsDTO> skillsDTOS = new ArrayList<>();
        skillsRepository.findAllByLanguageCode(languageEnum).iterator().forEachRemaining(skills -> skillsDTOS.add(SkillsMapper.INSTANCE.toDTO(skills)));
        return skillsDTOS;
    }
}
