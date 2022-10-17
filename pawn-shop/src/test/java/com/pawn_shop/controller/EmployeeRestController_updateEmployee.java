package com.pawn_shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pawn_shop.dto.EmployeeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_updateEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void updateEmployee_name_19() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(null);
        employeeDto.setAddress("Đà nẵng");
        employeeDto.setDateOfBirth(LocalDate.parse("1991-07-13"));
        employeeDto.setGender(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_name_20() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("");
        employeeDto.setAddress("Đà nẵng");
        employeeDto.setDateOfBirth(LocalDate.parse("1991-07-13"));
        employeeDto.setGender(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_name_21() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("232323");
        employeeDto.setAddress("Đà nẵng");
        employeeDto.setDateOfBirth(LocalDate.parse("1991-07-13"));
        employeeDto.setGender(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_name_22() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("");
        employeeDto.setAddress("Đà nẵng");
        employeeDto.setDateOfBirth(LocalDate.parse("1991-07-13"));
        employeeDto.setGender(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_name_23() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Tran Xuan Quynh");
        employeeDto.setAddress("Đà nẵng");
        employeeDto.setDateOfBirth(LocalDate.parse("1991-07-13"));
        employeeDto.setGender(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee_24() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Tran Xuan Quynh");
        employeeDto.setAddress("Đà Nẵng");
        employeeDto.setCode("NV-33");
        employeeDto.setDateOfBirth(LocalDate.parse("1999-08-08"));
        employeeDto.setEmail("quyntran@gmail.com");
        employeeDto.setGender(true);
        employeeDto.setImgUrl("f");
        employeeDto.setPhoneNumber("090526565");
        employeeDto.setIdCard("093333333333");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/employee/update")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
