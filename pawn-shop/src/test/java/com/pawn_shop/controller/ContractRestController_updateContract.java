package com.pawn_shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pawn_shop.dto.ContractDto;
import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.model.employee.Employee;
import com.pawn_shop.model.pawn.PawnImg;
import com.pawn_shop.model.pawn.PawnItem;
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
public class ContractRestController_updateContract {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateContract_endDate_19() throws Exception {

        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(null);
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(5000000.0);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_endDate_20() throws Exception {

        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse(""));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(5000000.0);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_endDate_21() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("zxczx"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(5000000.0);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_endDate_22() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("9999-12-31"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(5000000.0);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_endDate_23() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("0001-31-12"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(5000000.0);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_code_19() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode(null);
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(5000000.0);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_code_20() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(5000000.0);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_code_21() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("czxczxc");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(5000000.0);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_code_22() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("z");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(5000000.0);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_code_23() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("zzzzbbbbslkdjfladskfljsdhflkjasdhfldjkasfhdjkslfhfjkdsahfkljadshfljdkasfhaadsfasdkjhfjadskf");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(5000000.0);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_interestRate_19() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(null);
        contractDto.setItemPrice(5000000.0);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_interestRate_22() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(0.00000000000001);
        contractDto.setItemPrice(5000000.0);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_interestRate_23() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(9999998897897897987.0);
        contractDto.setItemPrice(5000000.0);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_itemPrice_19() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(null);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_itemPrice_22() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(0.00000000000000001);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_itemPrice_23() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(99876868778687.898);
        contractDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_startDate_19() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(10000.5);
        contractDto.setStartDate(null);
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_startDate_20() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(10000.5);
        contractDto.setStartDate(LocalDate.parse(""));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateContract_startDate_21() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(10000.5);
        contractDto.setStartDate(LocalDate.parse("zxczxczxc"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_startDate_22() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(10000.5);
        contractDto.setStartDate(LocalDate.parse("0001-12-31"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_startDate_23() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(10000.5);
        contractDto.setStartDate(LocalDate.parse("9999-12-31"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_customer_19() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(10000.5);
        contractDto.setStartDate(LocalDate.parse("2022-10-10"));
        contractDto.setStatus(0);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(null);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_customer_20() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(10000.5);
        contractDto.setStartDate(LocalDate.parse("2022-10-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_pawnItem_19() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(10000.5);
        contractDto.setStartDate(LocalDate.parse("2022-10-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(1L);

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_pawnItem_20() throws Exception {
        ContractDto contractDto = new ContractDto();
        contractDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractDto.setId(20L);
        contractDto.setCode("HD-NV0001-1");
        contractDto.setInterestRate(5.0);
        contractDto.setItemPrice(10000.5);
        contractDto.setStartDate(LocalDate.parse("2022-10-10"));
        contractDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(1L);

        PawnItem pawnItem = new PawnItem();

        contractDto.setCustomer(customer);

        contractDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
