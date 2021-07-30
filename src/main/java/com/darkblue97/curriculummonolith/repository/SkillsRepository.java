package com.darkblue97.curriculummonolith.repository;

import com.darkblue97.curriculummonolith.domain.Skills;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SkillsRepository extends MongoRepository<Skills, UUID> {
}
