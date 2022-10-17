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
public class EmployeeController_listAllEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllEmployee_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list/page?name"))
                .andDo(print())
                .andExpect(status().is(404));
    }

    @Test
    public void getAllEmployee_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list?name="))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    public void getAllEmployee_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list?name= 7dsjhgfuyd"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    @Test
    public void getListStudent_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/list?page= "))
                .andDo(print())
                .andExpect(status().is(200));
    }
}
