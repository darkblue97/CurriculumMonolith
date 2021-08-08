package com.darkblue97.curriculummonolith.domain;

import lombok.Data;

@Data
public class UuidDTO {
    private String id;

    public UuidDTO() {
    }

    public UuidDTO(String id) {
        this.id = id;
    }
}
