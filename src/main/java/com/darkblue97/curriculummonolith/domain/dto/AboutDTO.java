package com.darkblue97.curriculummonolith.domain.dto;

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
}
