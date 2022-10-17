package com.pawn_shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pawn_shop.model.login.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityController_authenticateUser {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    // loginRequest = null
    @Test
    public void authenticateUser_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(null))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(jsonPath("$").value("Không được để trống tài khoản, mật khẩu"))
                .andExpect(status().is(400));
    }

    // username = null
    @Test
    public void authenticateUser_2() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is(403));
    }

    // password = null
    @Test
    public void authenticateUser_3() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is(403));
    }

    // wrong username
    @Test
    public void authenticateUser_4() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("wrongUserName");
        loginRequest.setPassword("123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is(403));
    }

    // wrong password
    @Test
    public void authenticateUser_5() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("user1");
        loginRequest.setPassword("wrongPassword");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is(403));
    }

    // right loginRequest
    @Test
    public void authenticateUser_6() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("user5");
        loginRequest.setPassword("123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/public/login")
                        .content(this.objectMapper.writeValueAsString(loginRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is(200));
    }
}
