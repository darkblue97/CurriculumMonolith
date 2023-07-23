package com.darkblue97.curriculummonolith.domain;

import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(value = "aboutMe")
@AllArgsConstructor
public class AboutMe {
    @Id
    private UUID id;
    private String title;
    private String text;
    private String mediaId;
    private LanguageEnum languageCode;

}
