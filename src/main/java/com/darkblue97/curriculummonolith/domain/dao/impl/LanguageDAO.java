package com.darkblue97.curriculummonolith.domain.dao.impl;

import com.darkblue97.curriculummonolith.domain.Languages;
import com.darkblue97.curriculummonolith.domain.dao.DAOInterface;
import com.darkblue97.curriculummonolith.domain.dto.LanguagesDTO;
import com.darkblue97.curriculummonolith.domain.mappers.LanguageMapper;
import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.repository.LanguagesRepository;
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
public class LanguageDAO implements DAOInterface<LanguagesDTO> {

    private final LanguagesRepository languagesRepository;

    public LanguageDAO(LanguagesRepository languagesRepository) {
        this.languagesRepository = languagesRepository;
    }

    @Override
    public Optional<LanguagesDTO> get(UUID id) {
        return languagesRepository.findById(id).map(LanguageMapper.INSTANCE::toDTO);
    }

    @Override
    public List<LanguagesDTO> getAll(LanguageEnum languageEnum) {
        List<LanguagesDTO> languagesDTOS = new ArrayList<>();
        languagesRepository.findAll().iterator().forEachRemaining(k -> languagesDTOS.add(LanguageMapper.INSTANCE.toDTO(k)));
        return languagesDTOS;
    }

    @Override
    @Transactional
    public void save(LanguagesDTO languagesDTO) throws DataAlreadySavedException {
        Optional<LanguagesDTO> languageEnumOptional = getLanguage(languagesDTO.getLanguageCode());

        if (languageEnumOptional.isPresent()) {
            throw new DataAlreadySavedException("Data already saved with this language code");
        }

        Languages languages = LanguageMapper.INSTANCE.toEntity(languagesDTO);
        languages.setId(GenerationUUID.generate());
        languagesRepository.save(languages);
    }

    @Override
    @Transactional
    public void update(LanguagesDTO languagesDTO) {
        Optional<LanguagesDTO> toUpdateOptional = getLanguage(languagesDTO.getLanguageCode());
        if (toUpdateOptional.isPresent()) {
            LanguagesDTO toUpdate = toUpdateOptional.get();
            toUpdate.setId(languagesDTO.getId());
            toUpdate.setLanguage(languagesDTO.getLanguage());
            toUpdate.setLanguageCode(languagesDTO.getLanguageCode());
            toUpdate.setSpeak(languagesDTO.getSpeak());
            toUpdate.setListen(languagesDTO.getListen());
            toUpdate.setRead(languagesDTO.getRead());
        }
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        LanguagesDTO toDelete = get(id).orElseThrow(() -> new NotFoundException("Data not found"));
        Languages languages = LanguageMapper.INSTANCE.toEntity(toDelete);
        languagesRepository.delete(languages);
    }

    private Optional<LanguagesDTO> getLanguage(LanguageEnum languageCode) {
        return languagesRepository.findByLanguageCode(languageCode);
    }
}
