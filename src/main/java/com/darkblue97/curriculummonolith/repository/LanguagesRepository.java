package com.darkblue97.curriculummonolith.repository;

import com.darkblue97.curriculummonolith.domain.Languages;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LanguagesRepository extends MongoRepository<Languages, UUID> {
}
