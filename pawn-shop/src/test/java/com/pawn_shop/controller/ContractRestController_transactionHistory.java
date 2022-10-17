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

    // lấy ra danh sách giao dịch tồn tại thì trả về 1 page<ContractDto>
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
    public void getTransactionList_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/contracts?customerName=T"))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void getTransactionList_7_byPawnItemName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/contracts?pawnItemName=null"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getTransactionList_9_byPawnItemName() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/contracts?pawnItemName=xxx"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getTransactionList_7_byTypeContract() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/contracts?type=null"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getTransactionList_11_byTypeContract() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/contracts?type=true"))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void getTransactionList_11_byStartDate() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/contracts?startDate=2020-10-18"))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void getTransactionList_11_byEndDate() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/contracts?endDate=2022-10-18"))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void getTransactionList_8_byEndDate() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/contracts?endDate=2020-10-18"))
                .andDo(print())
                .andExpect(status().is(204));
    }
}
