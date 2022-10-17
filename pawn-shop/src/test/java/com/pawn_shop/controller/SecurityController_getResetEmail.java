package com.pawn_shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityController_getResetEmail {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    // email = null
    @Test
    public void getResetEmail_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/public/forgot-password")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(jsonPath("$").value("Không được để trống email"))
                .andExpect(status().is(400));
    }


    // wrong email
    @Test
    public void getResetEmail_2() throws Exception {

        String email = "wrongemail@gmail.com";
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/public/forgot-password")
                        .content(email)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(jsonPath("$").value("Email chưa được đăng ký"))
                .andExpect(status().is(400));
    }

    // right email
    @Test
    public void getResetEmail_3() throws Exception {
        String email = "01662121970ax@gmail.com";
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/public/forgot-password")
                        .content(email)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is(200));
    }

}
