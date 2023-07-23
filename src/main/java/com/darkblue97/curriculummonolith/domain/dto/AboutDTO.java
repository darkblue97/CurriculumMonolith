package com.darkblue97.curriculummonolith.domain.dto;

import com.darkblue97.curriculummonolith.domain.AboutMe;
import com.darkblue97.curriculummonolith.utils.GenerationUUID;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AboutDTO {
    private UUID id;
    private String title;
    private String text;
    private String mediaId;
    private LanguageEnum languageCode;

    public static AboutDTO toDTO(AboutMe aboutMe) {
        return new AboutDTO(
                aboutMe.getId(),
                aboutMe.getTitle(),
                aboutMe.getText(),
                aboutMe.getMediaId(),
                aboutMe.getLanguageCode()
        );
    }

    public static AboutMe toModel(AboutDTO aboutDTO) {
        return new AboutMe(
                GenerationUUID.generate(),
                aboutDTO.getTitle(),
                aboutDTO.getText(),
                aboutDTO.getMediaId(),
                aboutDTO.getLanguageCode()
        );
    }
}
