package com.darkblue97.curriculummonolith.service.impl;

import com.darkblue97.curriculummonolith.domain.dao.impl.SkillsDAO;
import com.darkblue97.curriculummonolith.domain.dto.SkillsDTO;
import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.service.SkillsService;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Component
@Service
public class SkillServiceImpl implements SkillsService {

    private final SkillsDAO skillsDAO;

    @Override
    public SkillsDTO getSkillInformation(LanguageEnum language) throws NotFoundException {
        return skillsDAO.get(language).orElseThrow(() -> new NotFoundException("Data not found"));
    }

    public SkillServiceImpl(SkillsDAO skillsDAO) {
        this.skillsDAO = skillsDAO;
    }

    @Override
    public List<SkillsDTO> getAll(LanguageEnum languageEnum) throws NotFoundException {
        return skillsDAO.getAll(languageEnum);
    }

    @Override
    public void putObject(SkillsDTO skillsDTO) throws NotFoundException {
        skillsDAO.update(skillsDTO);
    }

    @Override
    public void postObject(SkillsDTO skillsDTO) throws NotFoundException, DataAlreadySavedException {
        skillsDAO.save(skillsDTO);
    }

    @Override
    public void deleteObject(UUID id) throws NotFoundException {
        skillsDAO.delete(id);
    }
}
