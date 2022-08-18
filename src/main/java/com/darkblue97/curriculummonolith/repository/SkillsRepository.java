package com.darkblue97.curriculummonolith.repository;

import com.darkblue97.curriculummonolith.domain.Skills;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SkillsRepository extends MongoRepository<Skills, UUID> {
    Optional<Skills> findByLanguageCode(LanguageEnum languageEnum);

    List<Skills> findAllByLanguageCode(LanguageEnum languageEnum);
}
