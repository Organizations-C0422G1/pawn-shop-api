package com.pawn_shop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pawn_shop.dto.ContractDto;
import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.model.employee.Employee;
import com.pawn_shop.model.pawn.PawnItem;
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
public class ContractRestController_createContract {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createContract_endDate_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(null);
        contractDto.setCode("HD-NV001-1");
        contractDto.setInterestRate("15");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setStartDate("2022-15-12");
        contractDto.setItemPrice("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_endDate_14() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate("");
        contractDto.setCode("HD-NV001-1");
        contractDto.setInterestRate("15");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setStartDate("2022-15-12");
        contractDto.setItemPrice("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_endDate_15() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate("abc");
        contractDto.setCode("HD-NV001-1");
        contractDto.setInterestRate("15");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setStartDate("2022-15-12");
        contractDto.setItemPrice("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_endDate_18() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate("2022-12-12");
        contractDto.setCode("HD-NV001-1");
        contractDto.setInterestRate("15");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setStartDate("2022-15-12");
        contractDto.setItemPrice("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1l);
        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_startDate_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setStartDate(null);
        contractDto.setCode("HD-NV001-1");
        contractDto.setInterestRate("15");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setItemPrice("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_startDate_14() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setStartDate("");
        contractDto.setCode("HD-NV001-1");
        contractDto.setInterestRate("15");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setItemPrice("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_startDate_15() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setStartDate("abc");
        contractDto.setCode("HD-NV001-1");
        contractDto.setInterestRate("15");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setItemPrice("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_startDate_18() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setStartDate("2022-10-17");
        contractDto.setCode("HD-NV001-1");
        contractDto.setInterestRate("15");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setItemPrice("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1l);
        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_interestRate_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setInterestRate(null);
        contractDto.setCode("HD-NV001-1");
        contractDto.setStartDate("2022-10-17");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setItemPrice("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_interestRate_14() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setInterestRate("");
        contractDto.setCode("HD-NV001-1");
        contractDto.setStartDate("2022-10-17");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setItemPrice("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_interestRate_15() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setInterestRate("abc");
        contractDto.setCode("HD-NV001-1");
        contractDto.setStartDate("2022-10-17");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setItemPrice("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_interestRate_16() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setInterestRate("-5");
        contractDto.setCode("HD-NV001-1");
        contractDto.setStartDate("2022-10-17");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setItemPrice("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_interestRate_18() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setStartDate("2022-10-17");
        contractDto.setCode("HD-NV001-1");
        contractDto.setInterestRate("15");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setItemPrice("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1l);
        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createContract_itemPrice_13() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setItemPrice(null);
        contractDto.setCode("HD-NV001-1");
        contractDto.setStartDate("2022-10-17");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setInterestRate("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_itemPrice_14() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setItemPrice("");
        contractDto.setCode("HD-NV001-1");
        contractDto.setStartDate("2022-10-17");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setInterestRate("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_itemPrice_15() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setItemPrice("abc");
        contractDto.setCode("HD-NV001-1");
        contractDto.setStartDate("2022-10-17");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setInterestRate("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_itemPrice_16() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setItemPrice("-9");
        contractDto.setCode("HD-NV001-1");
        contractDto.setStartDate("2022-10-17");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setInterestRate("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createContract_itemPrice_18() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setItemPrice("9");
        contractDto.setCode("HD-NV001-1");
        contractDto.setStartDate("2022-10-17");
        contractDto.setStatus(0);
        contractDto.setType(true);
        contractDto.setEndDate("2022-15-12");
        contractDto.setInterestRate("454545454");
        contractDto.setReturnDate(null);
        contractDto.setLiquidationPrice(null);

        Customer customer = new Customer();
        customer.setId(20l);
        contractDto.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(20l);
        contractDto.setEmployee(employee);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(20l);
        contractDto.setPawnItem(pawnItem);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/contract/create")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
