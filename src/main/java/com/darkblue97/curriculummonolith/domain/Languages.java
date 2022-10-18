package com.darkblue97.curriculummonolith.domain;

import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.darkblue97.curriculummonolith.utils.MasteringLevel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(value = "Languages")
public class Languages {

    @Id
    private UUID id;
    private String language;
    private MasteringLevel read;
    private MasteringLevel speak;
    private MasteringLevel listen;
    private LanguageEnum languageCode;

    public Languages(UUID id, String language, MasteringLevel read, MasteringLevel speak, MasteringLevel listen, LanguageEnum languageCode) {
        this.id = id;
        this.language = language;
        this.read = read;
        this.speak = speak;
        this.listen = listen;
        this.languageCode = languageCode;
    }
}
