package com.darkblue97.curriculummonolith.domain.dto;

import com.darkblue97.curriculummonolith.domain.Languages;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.darkblue97.curriculummonolith.utils.MasteringLevel;
import lombok.Data;

@Data
public class LanguagesDTO {

    private String language;
    private MasteringLevel read;
    private MasteringLevel speak;
    private MasteringLevel listen;
    private LanguageEnum languageCode;

    public LanguagesDTO(String language, MasteringLevel read, MasteringLevel speak,
                        MasteringLevel listen, LanguageEnum languageCode) {
        this.language = language;
        this.read = read;
        this.speak = speak;
        this.listen = listen;
        this.languageCode = languageCode;
    }

    public static LanguagesDTO toDto(Languages languages) {
        return new LanguagesDTO(languages.getLanguage(), languages.getRead(), languages.getSpeak(),
                languages.getListen(), languages.getLanguageCode()
        );
    }
}
