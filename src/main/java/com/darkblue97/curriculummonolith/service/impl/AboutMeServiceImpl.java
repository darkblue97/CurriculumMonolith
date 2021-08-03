package com.darkblue97.curriculummonolith.service.impl;

import com.darkblue97.curriculummonolith.domain.dao.impl.AboutMeDAO;
import com.darkblue97.curriculummonolith.domain.dto.AboutDTO;
import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.service.AboutMeService;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class AboutMeServiceImpl implements AboutMeService {

    private final AboutMeDAO aboutMeDAO;

    public AboutMeServiceImpl(AboutMeDAO aboutMeDAO) {
        this.aboutMeDAO = aboutMeDAO;
    }

    @Override
    public AboutDTO getAboutMeInformation(LanguageEnum languageEnum) throws NotFoundException {
        return aboutMeDAO.get(languageEnum).orElseThrow(() -> new NotFoundException("Data not found"));
    }

    @Override
    public void postAboutMeInformation(AboutDTO aboutDTO) throws NotFoundException {
        aboutMeDAO.update(aboutDTO);
    }

    @Override
    public void putAboutMeInformation(AboutDTO aboutDTO) throws DataAlreadySavedException {
        aboutMeDAO.save(aboutDTO);
    }

    @Override
    public void deleteAboutMeInformation(AboutDTO aboutDTO) throws NotFoundException {
        aboutMeDAO.delete(aboutDTO);
    }
}
