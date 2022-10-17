package com.pawn_shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pawn_shop.dto.CustomerDTO;
import com.pawn_shop.model.address.Address;
import com.pawn_shop.model.customer.Customer;
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
public class CustomerRestController_createCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by: PhucNHD
     * Date Create: 17/10/2022
     * funtion: Post Customer
     *
     * @throws Exception this function use to test validation of field name more specific is Empty
     */

    @Test
    public void createStudent_name_14() throws Exception {
        CustomerDTO customerDTO= new CustomerDTO();
        customerDTO.setName("");
        customerDTO.setDateOfBirth(LocalDate.parse("2022-12-12"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("201790843");
        customerDTO.setStatus(false);
        Address address= new Address();
        address.setId(3l);
        customerDTO.setAddress(address);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/pawnShop/goCreateCustomer")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: PhucNHD
     * Date Create: 17/10/2022
     * funtion: Post Customer
     *
     * @throws Exception this function use to test validation of field name successfully
     */
    public void createStudent_name_18() throws Exception {
        CustomerDTO customerDTO= new CustomerDTO();
        customerDTO.setName("Nguyễn Hoàng Đa Phúc");
        customerDTO.setDateOfBirth(LocalDate.parse("2022-12-12"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("201790843");
        customerDTO.setStatus(false);
        Address address= new Address();
        address.setId(3l);
        customerDTO.setAddress(address);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/pawnShop/goCreateCustomer")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
