package com.darkblue97.curriculummonolith.repository;

import com.darkblue97.curriculummonolith.domain.Projects;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectsRepository extends MongoRepository<Projects, UUID> {
    Optional<Projects> findByLanguageCode(LanguageEnum languageEnum);

    List<Projects> findAllByLanguageCode(LanguageEnum languageEnum);
}
