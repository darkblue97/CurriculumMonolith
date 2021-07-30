package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.AboutDTO;
import com.darkblue97.curriculummonolith.repository.AboutMeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AboutMeDAO implements DAOInterface<AboutDTO> {

    @Autowired
    private AboutMeRepository aboutMeRepository;

    @Override
    public Optional<AboutDTO> get(UUID id) {
        return aboutMeRepository.findById(id).map(AboutDTO::toDTO);
    }

    @Override
    public List<AboutDTO> getAll() {
        return null;
    }

    @Override
    public void save(AboutDTO aboutDTO) {
    }

    @Override
    public void update(AboutDTO aboutDTO, String[] params) {

    }

    @Override
    public void delete(AboutDTO aboutDTO) {

    }
}
