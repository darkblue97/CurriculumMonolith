package com.darkblue97.curriculummonolith.rest;

import com.darkblue97.curriculummonolith.domain.dto.JobsDTO;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.service.ExperienceService;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.darkblue97.curriculummonolith.utils.response.ResponseEntityBuilderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping(value = "/experience/{language}")
    public ResponseEntity<Object> getAllExperience(@PathVariable("language") LanguageEnum language) {
        try {
            List<JobsDTO> jobsDTOS = experienceService.getAll(language);
            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.OK)
                    .setObjectResponse(jobsDTOS)
                    .setMessage("About me information")
                    .build();
        } catch (NotFoundException nte) {
            return new ResponseEntityBuilderResponse<>()
                    .setError(nte.toString())
                    .setStatus(HttpStatus.NOT_FOUND)
                    .setObjectResponse(nte.getLocalizedMessage())
                    .build();
        } catch (Exception ex) {
            return new ResponseEntityBuilderResponse<>()
                    .setError("Internal server error")
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PutMapping(value = "/experience")
    public ResponseEntity<Object> putExperience(@RequestBody JobsDTO jobsDTO) {
        try {
            experienceService.putObject(jobsDTO);
            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.OK)
                    .setMessage("Information successfully saved")
                    .build();
        } catch (Exception ex) {
            return new ResponseEntityBuilderResponse<>()
                    .setError("Internal server error")
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PostMapping(value = "/experience")
    public ResponseEntity<Object> postExperience(@RequestBody JobsDTO jobsDTO) {
        try {
            experienceService.postObject(jobsDTO);
            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.OK)
                    .setMessage("Information successfully saved")
                    .build();
        } catch (NotFoundException nte) {
            return new ResponseEntityBuilderResponse<>()
                    .setError(nte.toString())
                    .setStatus(HttpStatus.NOT_FOUND)
                    .setObjectResponse(nte.getLocalizedMessage())
                    .build();
        } catch (Exception ex) {
            return new ResponseEntityBuilderResponse<>()
                    .setError("Internal server error")
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @DeleteMapping(value = "/experience")
    public ResponseEntity<Object> deleteExperience(@RequestBody JobsDTO uid) {
        try {
            experienceService.deleteObject(uid.getId());
            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.OK)
                    .setMessage("Information successfully deleted")
                    .build();
        } catch (NotFoundException e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError("Exception deleting the about me")
                    .setObjectResponse(e.getLocalizedMessage())
                    .setStatus(HttpStatus.NOT_ACCEPTABLE)
                    .build();
        } catch (IllegalArgumentException e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError("The string provided is nota an UUID")
                    .setObjectResponse(e.getLocalizedMessage())
                    .setStatus(HttpStatus.NOT_ACCEPTABLE)
                    .build();
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError("Internal server error while saving")
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
