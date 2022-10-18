//package com.pawn_shop.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pawn_shop.dto.ContractDto;
//import com.pawn_shop.model.customer.Customer;
//import com.pawn_shop.model.employee.Employee;
//import com.pawn_shop.model.pawn.PawnItem;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ContractRestController_createContract {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//
////    use case endDate attribute to null value
//    @Test
//    public void createContract_endDate_13() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setEndDate(null);
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setStartDate("22-12-2022");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //    use case endDate attribute to "" value
//    @Test
//    public void createContract_endDate_14() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setEndDate("");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setStartDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //    use case endDate attribute to wrong format
//    @Test
//    public void createContract_endDate_15() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setEndDate("abc");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setStartDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //in correct case
//    @Test
//    public void createContract_endDate_18() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setEndDate("2022-12-12");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setStartDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(1l);
//        contractDto.setPawnItem(pawnItem);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
// //=> don't use case 16,17 because date is not available minLength or maxLength
//
//    //    use case startDate attribute to null value
//    @Test
//    public void createContract_startDate_13() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setStartDate(null);
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //    use case start attribute to "" value
//    @Test
//    public void createContract_startDate_14() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setStartDate("");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //    use case startDate attribute to wrong format
//    @Test
//    public void createContract_startDate_15() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setStartDate("abc");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //correct case
//    @Test
//    public void createContract_startDate_18() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(1l);
//        contractDto.setPawnItem(pawnItem);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    //=> don't use case 16,17 because date is not available minLength or maxLength
//
//    //check for null InterestRate condition
//    @Test
//    public void createContract_interestRate_13() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setInterestRate(null);
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //check for "" InterestRate condition
//    @Test
//    public void createContract_interestRate_14() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setInterestRate("");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //check for wrong format InterestRate condition
//    @Test
//    public void createContract_interestRate_15() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setInterestRate("abc");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //check for negative value
//    @Test
//    public void createContract_interestRate_16() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setInterestRate("-5");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //correct case
//    @Test
//    public void createContract_interestRate_18() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(1l);
//        contractDto.setPawnItem(pawnItem);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
////    Instead of checking minlength, maxlength, I check negative condition because the value is numeric
//
//    //check for null itemPrice condition
//    @Test
//    public void createContract_itemPrice_13() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setItemPrice(null);
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setInterestRate("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //check for "" itemPrice condition
//    @Test
//    public void createContract_itemPrice_14() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setItemPrice("");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setInterestRate("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //check wrong format for itemPrice condition
//    @Test
//    public void createContract_itemPrice_15() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setItemPrice("abc");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setInterestRate("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    //check for negative value
//    @Test
//    public void createContract_itemPrice_16() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setItemPrice("-9");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setInterestRate("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //correct case
//    @Test
//    public void createContract_itemPrice_18() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setItemPrice("9");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setInterestRate("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
////    Instead of checking minlength, maxlength, I check negative condition because the value is numeric
//
//    //check for null type condition
//    @Test
//    public void createContract_type_14() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setItemPrice("9");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(0);
//        contractDto.setType(null);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setInterestRate("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //correct case
//    @Test
//    public void createContract_type_18() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(1l);
//        contractDto.setPawnItem(pawnItem);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    //In this case, I will leave the default value for the case, so only test the case where the type has a null value
//
//    //check for incorrect input value
//    @Test
//    public void createContract_status_15() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setItemPrice("9");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(-9);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setInterestRate("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //correct case
//    @Test
//    public void createContract_status_18() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(1l);
//        contractDto.setPawnItem(pawnItem);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    //For this case, I will set the default value for status, so I only check the case of entering the wrong number in the rule
//
//    //check for null employee condition
//    @Test
//    public void createContract_employee_14() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setItemPrice("9");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(-9);
//        contractDto.setType(null);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setInterestRate("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(null);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //check for wrong format employee condition
//    @Test
//    public void createContract_employee_15() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setItemPrice("9");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(-9);
//        contractDto.setType(null);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setInterestRate("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(-8l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //correct case
//    @Test
//    public void createContract_employee_18() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(1l);
//        contractDto.setPawnItem(pawnItem);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    //check for null customer condition
//    @Test
//    public void createContract_customer_14() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setItemPrice("9");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(1);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setInterestRate("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(null);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(20l);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //correct case
//    @Test
//    public void createContract_customer_18() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(1l);
//        contractDto.setPawnItem(pawnItem);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    // In this case, the customer id is transmitted, so there is only the null case of the customer id
//
//   //check for null pawnItemId
//    @Test
//    public void createContract_pawnItem_14() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setItemPrice("9");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setStatus(1);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setInterestRate("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(null);
//        contractDto.setPawnItem(pawnItem);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //correct case
//    @Test
//    public void createContract_pawnItem_18() throws Exception {
//        ContractDto contractDto = new ContractDto();
//        contractDto.setStartDate("2022-10-17");
//        contractDto.setCode("HD-NV001-1");
//        contractDto.setInterestRate("15");
//        contractDto.setStatus(0);
//        contractDto.setType(true);
//        contractDto.setEndDate("2022-15-12");
//        contractDto.setItemPrice("454545454");
//        contractDto.setReturnDate(null);
//        contractDto.setLiquidationPrice(null);
//
//        Customer customer = new Customer();
//        customer.setId(20l);
//        contractDto.setCustomer(customer);
//
//        Employee employee = new Employee();
//        employee.setId(20l);
//        contractDto.setEmployee(employee);
//
//        PawnItem pawnItem = new PawnItem();
//        pawnItem.setId(1l);
//        contractDto.setPawnItem(pawnItem);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/contract/create")
//                        .content(this.objectMapper.writeValueAsString(contractDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    //In this case, I will add the pawn table first and then return the id of the pawn and put it in the contract, so there is only the case where the pawn id has a null value
//}
