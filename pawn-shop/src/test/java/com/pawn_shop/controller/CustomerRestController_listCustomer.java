//package com.pawn_shop.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CustomerRestController_listCustomer {
//    @Autowired
//    private MockMvc mockMvc;
//
//    /**
//     * @throws Exception
//     customerList with page =0, idCard = null
//     */
//    @Test
//    public void getAllCustomer_1_titleNull() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/list?page=0&idCard=null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    /**
//
//     * Get customer list with idCard = ""
//     * Return full list at page 1.true
//     */
//    @Test
//    public void getAllCustomer_2_titleEmpty() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/list?page=0&idCard="))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Get customer list with idCard is not exist
//     * Return an empty list at page 1.false
//     */
//    @Test
//    public void getAllCustomer_3_titleNotExist() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/list?page=0&idCard=54541"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * Get customer list with idCard exist
//     * Return an empty list at page 1.true
//     */
//    @Test
//    public void getAllCustomer_4_tittleExist() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/list?page=0&idCard=20117440"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("totalPages").value(2))
//                .andExpect(jsonPath("totalElements").value(20))
//                .andExpect(jsonPath("content[1].code").value("KH-1"))
//                .andExpect(jsonPath("content[1].dateOfBirth").value("1998-10-01"))
//                .andExpect(jsonPath("content[1].email").value("2022-12-28"))
//                .andExpect(jsonPath("content[1].idCard").value("20117440"))
//                .andExpect(jsonPath("content[1].imgUrl").value("2"))
//                .andExpect(jsonPath("content[1].name").value("Trọng Nghĩa"))
//                .andExpect(jsonPath("content[1].phoneNumber").value("0764052051"))
//                .andExpect(jsonPath("content[1].status").value("1"))
//                .andExpect(jsonPath("content[1].addressId").value("1"));
//    }
//
//    /**
//     * Get customer list with page = q
//     * Return full list at page 1 consists of q.true
//     */
//    @Test
//    public void getAllCustomer_5_pageEmpty() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/list?page=0&idCard=20117440"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//    /**
//     * Get customer list with page is not exist
//     * Return an empty list at page 1.false
//     */
//    @Test
//    public void getAllCustomer_6_pageNotExist() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/list?page=11&idCard=20117440"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    /**
//     * Get customer list with page exist
//     * Return  list at page 1.true
//     */
//    @Test
//    public void getAllCustomer_7_tittleExist() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/customer/list?page=0&idCard=20117440"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("totalPages").value(2))
//                .andExpect(jsonPath("totalElements").value(20))
//                .andExpect(jsonPath("content[1].code").value("KH-1"))
//                .andExpect(jsonPath("content[1].dateOfBirth").value("1998-10-01"))
//                .andExpect(jsonPath("content[1].email").value("2022-12-28"))
//                .andExpect(jsonPath("content[1].idCard").value("20117440"))
//                .andExpect(jsonPath("content[1].imgUrl").value("2"))
//                .andExpect(jsonPath("content[1].name").value("Trọng Nghĩa"))
//                .andExpect(jsonPath("content[1].phoneNumber").value("0764052051"))
//                .andExpect(jsonPath("content[1].status").value("1"))
//                .andExpect(jsonPath("content[1].addressId").value("1"));
//    }
//
//}
