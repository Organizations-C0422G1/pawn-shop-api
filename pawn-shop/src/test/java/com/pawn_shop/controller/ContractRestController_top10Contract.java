package com.pawn_shop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ContractRestController_top10Contract {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void top10Contract_5() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/top10Contract"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void top10Contract_6() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/top10Contract"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
