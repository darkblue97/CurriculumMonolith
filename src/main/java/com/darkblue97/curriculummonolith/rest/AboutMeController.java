package com.darkblue97.curriculummonolith.rest;

import com.darkblue97.curriculummonolith.domain.UuidDTO;
import com.darkblue97.curriculummonolith.domain.dto.AboutDTO;
import com.darkblue97.curriculummonolith.exceptions.DataAlreadySavedException;
import com.darkblue97.curriculummonolith.exceptions.NotFoundException;
import com.darkblue97.curriculummonolith.service.AboutMeService;
import com.darkblue97.curriculummonolith.utils.GenerationUUID;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import com.darkblue97.curriculummonolith.utils.response.ResponseEntityBuilderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AboutMeController {

    private final AboutMeService aboutMeService;

    public AboutMeController(AboutMeService aboutMeService) {
        this.aboutMeService = aboutMeService;
    }

    @GetMapping(value = "/about/{language}")
    public ResponseEntity<Object> getAboutMe(@PathVariable("language") LanguageEnum language) {
        try {
            AboutDTO aboutDTO = aboutMeService.getAboutMeInformation(language);
            return new ResponseEntityBuilderResponse<>()
                    .setStatus(HttpStatus.OK)
                    .setObjectResponse(aboutDTO)
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

    @PutMapping(value = "/about")
    public ResponseEntity<Object> putAboutMe(@RequestBody AboutDTO aboutDTO) {
        try {
            aboutMeService.putObject(aboutDTO);
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
                    .setError("Internal server error while saving")
                    .setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PostMapping(value = "/about")
    public ResponseEntity<Object> postAboutMe(@RequestBody AboutDTO aboutDTO) {
        try {
            aboutMeService.postObject(aboutDTO);
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
        } catch (DataAlreadySavedException e) {
            return new ResponseEntityBuilderResponse<>()
                    .setError("Exception saving the about me")
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

    @DeleteMapping(value = "/about")
    public ResponseEntity<Object> deleteAboutMe(@RequestBody String uid) {
        try {
            UuidDTO uuidDTO = new UuidDTO(uid);
            if (GenerationUUID.isUUIDValid(uuidDTO.getId())) {
                aboutMeService.deleteObject(GenerationUUID.returnUUIDFrmString(uuidDTO.getId()));
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
