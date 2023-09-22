package com.darkblue97.curriculummonolith.rest;

import com.darkblue97.curriculummonolith.domain.dto.ProjectsDTO;
import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.service.ProjectService;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.darkblue97.curriculummonolith.utils.response.ResponseEntityBuilderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectsController {
    private final ProjectService projectService;

    public ProjectsController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(value = "/project/{language}")
    public ResponseEntity<Object> getAboutMe(@PathVariable("language") LanguageEnum language) {
        try {
            ProjectsDTO projectsDTO = projectService.getProjectInformation(language);
            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.OK)
                    .setObjectResponse(projectsDTO)
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

    @PutMapping(value = "/project")
    public ResponseEntity<Object> putAboutMe(@RequestBody ProjectsDTO projectsDTO) {
        try {
            projectService.putObject(projectsDTO);
            return new ResponseEntityBuilderResponse<>()
                    .setMessage("Information successfully saved")
                    .setStatus(HttpStatus.OK)
                    .build();
        } catch (DataAlreadySavedException e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError("Exception saving the about me")
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

    @PostMapping(value = "/project")
    public ResponseEntity<Object> postAboutMe(@RequestBody ProjectsDTO projectsDTO) {
        try {
            projectService.postObject(projectsDTO);
            return new ResponseEntityBuilderResponse<>()
                    .setMessage("Information successfully saved")
                    .setStatus(HttpStatus.OK)
                    .build();
        } catch (NotFoundException e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError("Exception updating the about me")
                    .setObjectResponse(e.getLocalizedMessage())
                    .setStatus(HttpStatus.NOT_ACCEPTABLE)
                    .build();
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError("Internal server error while updating")
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @DeleteMapping(value = "/project")
    public ResponseEntity<Object> deleteAboutMe(@RequestBody ProjectsDTO uid) {
        try {
            projectService.deleteObject(uid.getId());
            return new ResponseEntityBuilderResponse<>()
                    .setMessage("Information successfully deleted")
                    .setStatus(HttpStatus.OK)
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