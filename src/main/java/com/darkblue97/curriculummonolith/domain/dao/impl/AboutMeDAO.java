package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.AboutMe;
import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.AboutDTO;
import com.darkblue97.curriculummonolith.domain.mappers.AboutMapper;
import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.repository.AboutMeRepository;
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
public class AboutMeDAO implements DAOInterface<AboutDTO> {

    private final AboutMeRepository aboutMeRepository;

    public AboutMeDAO(AboutMeRepository aboutMeRepository) {
        this.aboutMeRepository = aboutMeRepository;
    }

    public Optional<AboutDTO> get(LanguageEnum language) {
        return aboutMeRepository.findByLanguageCode(language).map(AboutMapper.INSTANCE::toDTO);
    }

    @Override
    public Optional<AboutDTO> get(UUID id) {
        return aboutMeRepository.findById(id).map(AboutMapper.INSTANCE::toDTO);
    }

    @Override
    public List<AboutDTO> getAll(LanguageEnum languageEnum) {
        List<AboutDTO> aboutDTOS = new ArrayList<>();
        aboutMeRepository.findAll().iterator().forEachRemaining(k -> aboutDTOS.add(AboutMapper.INSTANCE.toDTO(k)));
        return aboutDTOS;
    }

    public List<AboutDTO> getAllByLanguageCode(LanguageEnum languageEnum) {
        List<AboutDTO> aboutDTOS = new ArrayList<>();
        aboutMeRepository.findAllByLanguageCode(languageEnum).iterator().forEachRemaining(k -> aboutDTOS.add(AboutMapper.INSTANCE.toDTO(k)));
        return aboutDTOS;
    }

    @Override
    @Transactional
    public void save(AboutDTO aboutDTO) throws DataAlreadySavedException {

        if (!getAllByLanguageCode(aboutDTO.getLanguageCode()).isEmpty()) {
            throw new DataAlreadySavedException("Data already saved with this language code");
        }

        AboutMe aboutMe = AboutMapper.INSTANCE.toEntity(aboutDTO);
        aboutMe.setId(GenerationUUID.generate());
        aboutMeRepository.save(aboutMe);
    }

    @Override
    @Transactional
    public void update(AboutDTO aboutDTO) throws NotFoundException {
        AboutDTO aboutMeToUpdate = get(aboutDTO.getId()).orElseThrow(() -> new NotFoundException("Data not found"));
        aboutMeToUpdate.setTitle(aboutDTO.getTitle());
        aboutMeToUpdate.setText(aboutDTO.getText());
        aboutMeToUpdate.setMediaId(aboutDTO.getMediaId());
        aboutMeToUpdate.setLanguageCode(aboutDTO.getLanguageCode());
        AboutMe aboutMe = AboutMapper.INSTANCE.toEntity(aboutMeToUpdate);
        aboutMeRepository.save(aboutMe);
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        AboutDTO aboutMeToDelete = get(id).orElseThrow(() -> new NotFoundException("Data not found"));
        AboutMe aboutMe = AboutMapper.INSTANCE.toEntity(aboutMeToDelete);
        aboutMeRepository.delete(aboutMe);
    }
}
