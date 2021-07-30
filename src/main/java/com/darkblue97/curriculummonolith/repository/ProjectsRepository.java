package com.darkblue97.curriculummonolith.repository;

import com.darkblue97.curriculummonolith.domain.Projects;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProjectsRepository extends MongoRepository<Projects, UUID> {
}
