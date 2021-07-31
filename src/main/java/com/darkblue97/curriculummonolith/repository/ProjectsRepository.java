package com.darkblue97.curriculummonolith.repository;

import com.darkblue97.curriculummonolith.domain.Projects;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectsRepository extends MongoRepository<Projects, UUID> {
}
