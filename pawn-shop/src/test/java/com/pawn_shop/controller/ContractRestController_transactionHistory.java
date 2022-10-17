package com.pawn_shop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContractRestController_transactionHistory {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTransactionHistoryList_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/employee/contracts"))
                        .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getTransactionHistoryList_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/employee/contracts?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(17))
                .andExpect(jsonPath("content[3].customer").value("Trọng Nhân"))
                .andExpect(jsonPath("content[3].startDate").value("2022-03-14"))
                .andExpect(jsonPath("content[3].code").value("HD-NV002-4"));
    }

    @Test
    public void getTransactionList_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/contracts?customerName=null"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getTransactionList_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/contracts?customerName=T"))
                .andDo(print())
                .andExpect(status().is(204));
    }


}
