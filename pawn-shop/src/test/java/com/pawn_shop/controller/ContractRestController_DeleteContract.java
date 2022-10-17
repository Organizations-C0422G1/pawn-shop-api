package com.pawn_shop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContractRestController_DeleteContract {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteContract_19() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/employee/contracts/{id}", "null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteContract_18() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.patch("/api/employee/contracts/{id}", "11"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
