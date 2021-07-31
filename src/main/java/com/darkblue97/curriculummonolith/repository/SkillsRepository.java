package com.darkblue97.curriculummonolith.repository;

import com.darkblue97.curriculummonolith.domain.Skills;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillsRepository extends MongoRepository<Skills, UUID> {
}
