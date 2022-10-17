package com.pawn_shop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContractRestController_TransactionDetail {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInfoContract_id_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/employee/contracts/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/employee/contracts/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("code").value("HD-NV001-1"))
                .andExpect(jsonPath("startDate").value("2022-11-10"))
                .andExpect(jsonPath("endDate").value("2022-10-16"))
                .andExpect(jsonPath("customer").value("Trọng Nhân"))
                .andExpect(jsonPath("pawnItem").value("Dây chuyền vàng"));
    }
}
