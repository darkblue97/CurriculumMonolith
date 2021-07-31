package com.darkblue97.curriculummonolith.repository;

import com.darkblue97.curriculummonolith.domain.AboutMe;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AboutMeRepository extends MongoRepository<AboutMe, UUID> {
    Optional<AboutMe> findByLanguageCode(LanguageEnum languageEnum);

    List<AboutMe> findAllByLanguageCode(LanguageEnum languageEnum);
}
