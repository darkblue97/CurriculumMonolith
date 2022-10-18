package com.darkblue97.curriculummonolith.rest;

import com.darkblue97.curriculummonolith.domain.UuidDTO;
import com.darkblue97.curriculummonolith.domain.dto.SkillsDTO;
import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.service.SkillsService;
import com.darkblue97.curriculummonolith.utils.GenerationUUID;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.darkblue97.curriculummonolith.utils.response.ResponseEntityBuilderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SkillsController {
    private final SkillsService skillsService;

    public SkillsController(SkillsService skillsService) {
        this.skillsService = skillsService;
    }

    @GetMapping(value = "/skill/{language}")
    public ResponseEntity<Object> getAboutMe(@PathVariable("language") LanguageEnum language) {
        try {
            SkillsDTO skillsDTO = skillsService.getSkillInformation(language);
            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.OK)
                    .setObjectResponse(skillsDTO)
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

    @PutMapping(value = "/skill")
    public ResponseEntity<Object> putAboutMe(@RequestBody SkillsDTO skillsDTO) {
        try {
            skillsService.putObject(skillsDTO);
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

    @PostMapping(value = "/skill")
    public ResponseEntity<Object> postAboutMe(@RequestBody SkillsDTO skillsDTO) {
        try {
            skillsService.postObject(skillsDTO);
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

    @DeleteMapping(value = "/skill")
    public ResponseEntity<Object> deleteAboutMe(@RequestBody String uid) {
        try {
            UuidDTO uuidDTO = new UuidDTO(uid);
            if (GenerationUUID.isUUIDValid(uuidDTO.getId())) {
                skillsService.deleteObject(GenerationUUID.returnUUIDFrmString(uuidDTO.getId()));
            } else {
                return new ResponseEntityBuilderResponse<>()
                        .setStatus(HttpStatus.OK)
                        .setMessage("UUID provided does not exist")
                        .build();
            }

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
        } catch (Exception e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError("Internal server error while saving")
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
