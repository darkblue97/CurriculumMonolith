package com.darkblue97.curriculummonolith.repository;

import com.darkblue97.curriculummonolith.domain.Languages;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface LanguagesRepository extends MongoRepository<Languages, UUID> {
}
