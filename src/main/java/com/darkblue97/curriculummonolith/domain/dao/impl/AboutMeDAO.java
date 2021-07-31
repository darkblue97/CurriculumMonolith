package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.AboutDTO;
import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.repository.AboutMeRepository;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Component
public class AboutMeDAO implements DAOInterface<AboutDTO> {

    private final AboutMeRepository aboutMeRepository;

    public AboutMeDAO(AboutMeRepository aboutMeRepository) {
        this.aboutMeRepository = aboutMeRepository;
    }

    @Override
    public Optional<AboutDTO> get(LanguageEnum language) {
        return aboutMeRepository.findByLanguageCode(language).map(AboutDTO::toDTO);
    }

    @Override
    public Optional<AboutDTO> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<AboutDTO> getAll() {
        List<AboutDTO> aboutDTOS = new ArrayList<>();
        aboutMeRepository.findAll().iterator().forEachRemaining(k -> aboutDTOS.add(AboutDTO.toDTO(k)));
        return aboutDTOS;
    }

    public List<AboutDTO> getAllByLanguageCode(LanguageEnum languageEnum) {
        List<AboutDTO> aboutDTOS = new ArrayList<>();
        aboutMeRepository.findAllByLanguageCode(languageEnum).iterator().forEachRemaining(k -> aboutDTOS.add(AboutDTO.toDTO(k)));
        return aboutDTOS;
    }

    @Override
    public void save(AboutDTO aboutDTO) throws DataAlreadySavedException {

        if(!getAllByLanguageCode(aboutDTO.getLanguageCode()).isEmpty()){
            throw new DataAlreadySavedException("Data already saved with this language code");
        }

        aboutMeRepository.save(AboutDTO.toModel(aboutDTO));
    }

    @Override
    public void update(AboutDTO aboutDTO, String[] params) {

    }

    @Override
    public void delete(AboutDTO aboutDTO) {

    }
}
