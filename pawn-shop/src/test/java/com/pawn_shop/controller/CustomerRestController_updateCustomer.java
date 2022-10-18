package com.pawn_shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pawn_shop.dto.CustomerDTO;
import com.pawn_shop.model.address.Address;
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
public class CustomerRestController_updateCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by: PhucNHD
     * Date Create: 17/10/2022
     * funtion: Post Customer
     *
     * @throws Exception this function  to test validation of field name more specific is Empty
     */

    @Test
    public void updateCustomer_name_20() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("");
        customerDTO.setDateOfBirth(LocalDate.parse("2022-12-12"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("201790843");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
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
     * @throws Exception this function to test validation of field name does not contain special characters
     */

    @Test
    public void updateCustomer_name_21() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("@#$");
        customerDTO.setDateOfBirth(LocalDate.parse("2022-12-12"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("201790843");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
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
     * @throws Exception this function to test validation of field name successfully
     */
    public void updateCustomer_name_24() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Nguyễn Hoàng Đa Phúc");
        customerDTO.setDateOfBirth(LocalDate.parse("2022-12-12"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("201790843");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: PhucNHD
     * Date Create: 17/10/2022
     * funtion: Post Customer
     *
     * @throws Exception this function to test validation of field image more specific is Empty
     */
    @Test
    public void updateCustomer_image_20() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("2022-12-12"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
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
     * @throws Exception this function to test validation of field image more can't access the link
     */
    @Test
    public void updateCustomer_image_21() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("2022-12-12"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("http:firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
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
     * @throws Exception this function use to test validation of field image more specific is successfully
     */
    @Test
    public void updateCustomer_image_24() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("2022-12-12"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("http//firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: PhucNHD
     * Date Create: 17/10/2022
     * funtion: Post Customer
     *
     * @throws Exception this function to test validation of field date of birth more specific is successfully
     */
    @Test
    public void updateCustomer_dateOfBirth_24() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("1999-12-12"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("http//firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: PhucNHD
     * Date Create: 17/10/2022
     * funtion: Post Customer
     *
     * @throws Exception this function use to test validation of field date of birth is empty
     */
    @Test
    public void updateCustomer_dateOfBirth_20() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse(""));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("http//firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
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
     * @throws Exception this function use to test validation of field date of birth has age <18
     */
    @Test
    public void updateCustomer_dateOfBirth_22() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("2022-12-12"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("http//firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
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
     * @throws Exception this function use to test validation of field date of birth has age  >120
     */
    @Test
    public void updateCustomer_dateOfBirth_23() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("1800-12-12"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("http//firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
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
     * @throws Exception this function to test validation of field Phone number is empty
     */
    @Test
    public void updateCustomer_phoneNumber_20() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("2022-10-10"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("http//firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
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
     * @throws Exception this function to test validation of field Phone number is contain words or special characters
     */
    @Test
    public void updateCustomer_phoneNumber_21() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("2022-10-10"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("dqeqewqe@!");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("http//firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
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
     * @throws Exception this function use to test validation of field Phone number is successfully
     */
    @Test
    public void updateCustomer_phoneNumber_24() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("2022-10-10"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("http//firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: PhucNHD
     * Date Create: 17/10/2022
     * funtion: Post Customer
     *
     * @throws Exception this function to test validation of field id card is empty
     */
    @Test
    public void updateCustomer_idCard_20() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("2018-10-10"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("");
        customerDTO.setImgUrl("http//firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
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
     * @throws Exception this function to test validation of field id card is wrong format
     */
    @Test
    public void updateCustomer_idCard_21() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("2018-10-10"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("12e2rwe5ew5");
        customerDTO.setImgUrl("http//firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
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
     * @throws Exception this function to test validation of field id card is <9 numbers
     */
    @Test
    public void updateCustomer_idCard_22() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("2018-10-10"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("123");
        customerDTO.setImgUrl("http//firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
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
     * @throws Exception this function to test validation of field id card is > 9 numbers
     */
    @Test
    public void updateCustomer_idCard_23() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("2018-10-10"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("1234567899");
        customerDTO.setImgUrl("http//firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
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
     * @throws Exception this function  to test validation of field id card is successfully
     */
    @Test
    public void updateCustomer_idCard_24() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Hùng Dũng");
        customerDTO.setDateOfBirth(LocalDate.parse("2010-10-10"));
        customerDTO.setEmail("daphuc200@gmail.com");
        customerDTO.setPhoneNumber("0905005005");
        customerDTO.setGender(true);
        customerDTO.setIdCard("201790843");
        customerDTO.setImgUrl("http//firebase");
        customerDTO.setStatus(false);
        Address address = new Address();
        address.setId(3l);
        customerDTO.setAddress(address);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/pawnShop/goUpdateCustomer")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
