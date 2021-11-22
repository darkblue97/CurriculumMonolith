package com.darkblue97.curriculummonolith.controller;


import com.darkblue97.curriculummonolith.TestSetUp;
import com.darkblue97.curriculummonolith.repository.AboutMeRepository;
import com.darkblue97.curriculummonolith.utils.LanguageEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class AboutMeControllerTest extends TestSetUp {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private AboutMeRepository aboutMeRepository;

    @Test
    public void givenGetAboutMe_whenDataExist_thenReturnOk() throws Exception {
        MONGO_DB_CONTAINER.getLogs();
        when(aboutMeRepository.findByLanguageCode(any())).thenReturn(setUpDataAboutMe());

        mvc.perform(get("/experience/" + LanguageEnum.CAT)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

//    @Test
//    public void givenPostAboutMe_whenBodyCorrectAndDataExist_thenReturnOk() {
//
//    }
//
//    @Test
//    public void givenPutAboutMe_whenBodyCorrect_thenReturnOk() {
//
//    }
//
//    @Test
//    public void givenDeleteAboutMe_whenBodyCorrect_thenReturnOk() {
//
//    }
//
//    @Test
//    public void givenGetAboutMe_whenDataNoExist_thenReturnKo() {
//
//    }
//
//    @Test
//    public void givenPostAboutMe_whenDataNoExist_thenReturnKo() {
//
//    }
//
//    @Test
//    public void givenPutAboutMe_whenDataExist_thenReturnKo() {
//
//    }
//
//    @Test
//    public void givenDeleteAboutMe_whenDataNoExist_thenReturnKo() {
//
//    }
}
