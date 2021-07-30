package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.SkillsDTO;
import com.darkblue97.curriculummonolith.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SkillsDAO implements DAOInterface<SkillsDTO> {

    @Autowired
    private SkillsRepository skillsRepository;

    @Override
    public Optional<SkillsDTO> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<SkillsDTO> getAll() {
        return null;
    }

    @Override
    public void save(SkillsDTO skillsDTO) {

    }

    @Override
    public void update(SkillsDTO skillsDTO, String[] params) {

    }

    @Override
    public void delete(SkillsDTO skillsDTO) {

    }
}
