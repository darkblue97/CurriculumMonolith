package com.darkblue97.curriculummonolith.domain.dto;

import com.darkblue97.curriculummonolith.domain.AboutMe;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import lombok.Data;

@Data
public class AboutDTO {
    private String title;
    private String text;
    private String mediaId;
    private LanguageEnum languageCode;

    public AboutDTO(String title, String text, String mediaId, LanguageEnum languageCode) {
        this.title = title;
        this.text = text;
        this.mediaId = mediaId;
        this.languageCode = languageCode;
    }

    public static AboutDTO toDTO(AboutMe aboutMe) {
        return new AboutDTO(aboutMe.getTitle(), aboutMe.getText(), aboutMe.getMediaId(), aboutMe.getLanguageCode());
    }
}
