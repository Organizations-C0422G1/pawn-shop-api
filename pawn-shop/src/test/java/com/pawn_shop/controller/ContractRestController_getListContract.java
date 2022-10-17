package com.pawn_shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class ContractRestController_getListContract {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getListContract_7() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?page=0&code=", "null" + "&customerName=", "null"
                        + "pawnItem=", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListContract_8() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?page=0&code=", "" + "&customerName=", "" + "&pawnItem=", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListContract_9() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?page=0&code=", "HD-NV002-1" + "&customerName=", "Trọng Nghĩ" + "&pawnItem=", "Dây chuyền"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListContract_10() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?page=0&code=", "HD-NV002-4" + "&customerName=", "Trọng Nhân" + "&pawnItem=", "Yamaha Exciter 150"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(9))
                .andExpect(jsonPath("content[4].code").value("HD-NV002-4"))
                .andExpect(jsonPath("content[4].customer.id").value("Trọng Nhân"))
                .andExpect(jsonPath("content[4].pawnItem.id").value("Yamaha Exciter 150"))
                .andExpect(jsonPath("content[4].itemPrice").value(12000000))
                .andExpect(jsonPath("content[4].startDate").value("2022-03-14"))
                .andExpect(jsonPath("content[4].endDate").value("2022-05-15"))
                .andExpect(jsonPath("content[4].interestRate").value(5))
                .andExpect(jsonPath("content[4].returnDate").value("null"))
                .andExpect(jsonPath("content[4].liquidationPrice").value("null"));
    }
}

