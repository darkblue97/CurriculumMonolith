package com.darkblue97.curriculummonolith.repository;

import com.darkblue97.curriculummonolith.domain.AboutMe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AboutMeRepository extends MongoRepository<AboutMe, UUID> {
}
