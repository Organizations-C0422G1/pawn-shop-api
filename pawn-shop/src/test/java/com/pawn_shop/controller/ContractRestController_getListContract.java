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
    public void getListContract_code_7() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?code=" + null))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getListContract_code_8() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?code="))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void getListContract_code_9() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?code=HĐ-09555"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getListContract_code_10() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?code=HD-NV004-6"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getListContract_code_11() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?page=0&code=HD-NV003"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[1].code").value("HD-NV003-16"))
                .andExpect(jsonPath("content[1].customer").value("Tấn Tài"))
                .andExpect(jsonPath("content[1].pawnItem").value("Túi xách Hermes Kelly"))
                .andExpect(jsonPath("content[1].itemPrice").value(1400000.0))
                .andExpect(jsonPath("content[1].startDate").value("2022-02-03"))
                .andExpect(jsonPath("content[1].endDate").value("2022-02-19"))
                .andExpect(jsonPath("content[1].interestRate").value(4.0));

    }

    @Test
    public void getListContract_customerName_7() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?customerName=" + null))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getListContract_customerName_8() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?customerName= "))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void getListContract_customerName_9() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?customerName=Trọng Nhâ"))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void getListContract_customerName_10() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?customerName=Phi Hùng"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getListContract_customerName_11() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?page=0&customerName=Tấn"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].code").value("HD-NV003-16"))
                .andExpect(jsonPath("content[0].customer").value("Tấn Tài"))
                .andExpect(jsonPath("content[0].pawnItem").value("Túi xách Hermes Kelly"))
                .andExpect(jsonPath("content[0].itemPrice").value(1400000.0))
                .andExpect(jsonPath("content[0].startDate").value("2022-02-03"))
                .andExpect(jsonPath("content[0].endDate").value("2022-02-19"))
                .andExpect(jsonPath("content[0].interestRate").value(4.0));
    }

    @Test
    public void getListContract_pawnItem_7() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?pawnItem=" + null))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getListContract_pawnItem_8() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?pawnItem="))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void getListContract_pawnItem_9() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?pawnItem=Yamaha Excit"))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void getListContract_pawnItem_10() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?pawnItem=IPhone 14 ProMax"))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void getListContract_pawnItem_11() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?page=0&pawnItem=Ô tô VinFast Lux SA2.0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].code").value("HD-NV003-5"))
                .andExpect(jsonPath("content[0].customer").value("Anh Tài"))
                .andExpect(jsonPath("content[0].pawnItem").value("Ô tô VinFast Lux SA2.0"))
                .andExpect(jsonPath("content[0].itemPrice").value(99000000))
                .andExpect(jsonPath("content[0].startDate").value("2022-05-20"))
                .andExpect(jsonPath("content[0].endDate").value("2022-06-07"))
                .andExpect(jsonPath("content[0].interestRate").value(5.0));
    }

    @Test
    public void getListContract_startDate_7() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/contracts/listPage?startDate="))
                .andDo(print())
                .andExpect(status().is(204));
    }
}

