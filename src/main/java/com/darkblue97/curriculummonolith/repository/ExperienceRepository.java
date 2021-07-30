package com.darkblue97.curriculummonolith.repository;

import com.darkblue97.curriculummonolith.domain.Jobs;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ExperienceRepository extends MongoRepository<Jobs, UUID> {
}
