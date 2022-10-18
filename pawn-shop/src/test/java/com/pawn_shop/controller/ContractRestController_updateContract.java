package com.pawn_shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pawn_shop.dto.ContractUpdateDto;
import com.pawn_shop.model.customer.Customer;
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

        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(null);
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(5000000.0);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_endDate_20() throws Exception {

        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse(""));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(5000000.0);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_endDate_21() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("zxczx"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(5000000.0);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_endDate_22() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("9999-12-31"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(5000000.0);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_endDate_23() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("0001-31-12"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(5000000.0);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_code_19() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode(null);
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(5000000.0);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_code_20() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(5000000.0);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_code_21() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("czxczxc");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(5000000.0);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_code_22() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("z");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(5000000.0);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_code_23() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("zzzzbbbbslkdjfladskfljsdhflkjasdhfldjkasfhdjkslfhfjkdsahfkljadshfljdkasfhaadsfasdkjhfjadskf");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(5000000.0);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_interestRate_19() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(null);
        contractUpdateDto.setItemPrice(5000000.0);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_interestRate_22() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(0.00000000000001);
        contractUpdateDto.setItemPrice(5000000.0);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_interestRate_23() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(9999998897897897987.0);
        contractUpdateDto.setItemPrice(5000000.0);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_itemPrice_19() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(null);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_itemPrice_22() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(0.00000000000000001);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_itemPrice_23() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(99876868778687.898);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-11-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_startDate_19() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(10000.5);
        contractUpdateDto.setStartDate(null);
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_startDate_20() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(10000.5);
        contractUpdateDto.setStartDate(LocalDate.parse(""));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateContract_startDate_21() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(10000.5);
        contractUpdateDto.setStartDate(LocalDate.parse("zxczxczxc"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_startDate_22() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(10000.5);
        contractUpdateDto.setStartDate(LocalDate.parse("0001-12-31"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_startDate_23() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(10000.5);
        contractUpdateDto.setStartDate(LocalDate.parse("9999-12-31"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(4L);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_customer_19() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(10000.5);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-10-10"));
        contractUpdateDto.setStatus(0);

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(null);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_customer_20() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(10000.5);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-10-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();

        PawnItem pawnItem = new PawnItem();
        pawnItem.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_pawnItem_19() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(10000.5);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-10-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(1L);

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateContract_pawnItem_20() throws Exception {
        ContractUpdateDto contractUpdateDto = new ContractUpdateDto();
        contractUpdateDto.setEndDate(LocalDate.parse("2022-10-14"));
        contractUpdateDto.setId(20L);
        contractUpdateDto.setCode("HD-NV0001-1");
        contractUpdateDto.setInterestRate(5.0);
        contractUpdateDto.setItemPrice(10000.5);
        contractUpdateDto.setStartDate(LocalDate.parse("2022-10-10"));
        contractUpdateDto.setStatus(0);

        Customer customer = new Customer();
        customer.setId(1L);

        PawnItem pawnItem = new PawnItem();

        contractUpdateDto.setCustomer(customer);

        contractUpdateDto.setPawnItem(pawnItem);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/update-contract")
                        .content(this.objectMapper.writeValueAsString(contractUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
