package com.pawn_shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pawn_shop.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContractRestController_createQuickContract {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //case null can not manifest
    @Test
    public void createQuickContract_name_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(1L);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName(null);
        customerDto.setPhoneNumber("0909123456");
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(1L);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createQuickContract_name_14() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(1L);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName("");
        customerDto.setPhoneNumber("0909123456");
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(1L);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createQuickContract_name_15() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(1L);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName("123truong123");
        customerDto.setPhoneNumber("0909123456");
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(1L);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createQuickContract_name_16() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(1L);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName("Aa");
        customerDto.setPhoneNumber("0909123456");
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(1L);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createQuickContract_name_17() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(1L);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName("Saisaisaisaisaisaisaisai Saisaisaisaiasiasiasiasiasiasiasilkjdlaskjdklasjdaskdaskjdaskjdaskldjaslkasiasiasiasiasiasia");
        customerDto.setPhoneNumber("0909123456");
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(1L);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createQuickContract_name_18() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(1L);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName("Ten Ok");
        customerDto.setPhoneNumber("0909123456");
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(1L);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //case null can not manifest
    @Test
    public void createQuickContract_phoneNumber_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(1L);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName("Ten Ok");
        customerDto.setPhoneNumber(null);
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(1L);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createQuickContract_phoneNumber_14() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(1L);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName("Ten Ok");
        customerDto.setPhoneNumber("");
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(1L);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createQuickContract_phoneNumber_15() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(1L);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName("Ten Ok");
        customerDto.setPhoneNumber("motba");
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(1L);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createQuickContract_phoneNumber_18() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(1L);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName("Ten Ok");
        customerDto.setPhoneNumber("0909123456");
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(1L);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //District is a dropdown selected, so there is a case - "null"
    @Test
    public void createQuickContract_district_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(null);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName("Ten Ok");
        customerDto.setPhoneNumber("0909123123");
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(1L);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createQuickContract_district_18() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(1L);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName("Ten Ok");
        customerDto.setPhoneNumber("0909123456");
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(1L);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

//Pawn Type is a dropdown selected, so there is a case "null"
    @Test
    public void createQuickContract_pawnType_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(1L);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName("Ten Ok");
        customerDto.setPhoneNumber("0909123123");
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(null);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createQuickContract_pawnType_18() throws Exception {
        ContractDto contractDto = new ContractDto();
        CustomerDto customerDto = new CustomerDto();
        PawnTypeDto pawnTypeDto = new PawnTypeDto();
        PawnItemDto pawnItemDto = new PawnItemDto();
        AddressDto addressDto = new AddressDto();
        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(1L);
        addressDto.setDistrictDto(districtDto);
        customerDto.setName("Ten Ok");
        customerDto.setPhoneNumber("0909123456");
        customerDto.setAddressDto(addressDto);

        pawnTypeDto.setId(1L);
        pawnItemDto.setPawnTypeDto(pawnTypeDto);

        contractDto.setCustomerDto(customerDto);
        contractDto.setPawnItemDto(pawnItemDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contracts/createQuickContract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
