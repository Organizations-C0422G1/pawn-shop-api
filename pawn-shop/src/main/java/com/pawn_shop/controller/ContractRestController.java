package com.pawn_shop.controller;

import com.pawn_shop.config.MailConfig;
import com.pawn_shop.dto.ContractDtoHd;
import com.pawn_shop.dto.projection.ContractDto;
import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.service.IContractService;
import com.pawn_shop.service.ISendMailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/employee/contracts")
public class ContractRestController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private ISendMailService sendMailService;

    @GetMapping("")
    public ResponseEntity<Page<ContractDto>> transactionHistory(
            @RequestParam Optional<String> customerName,
            @RequestParam Optional<String> pawnItemName,
            @RequestParam Optional<String> type,
            @RequestParam Optional<String> startDate,
            @RequestParam Optional<String> endDate,
            @RequestParam Optional<String> status,
            @PageableDefault(size = 20) Pageable pageable) {
        String types = type.orElse("");
        String cusName = customerName.orElse("");
        String pawnItem = pawnItemName.orElse("");
        String startDay = startDate.orElse("0000-00-00");
        String endDay = endDate.orElse("2032-01-01");
        String status1 = status.orElse("");
        Page<ContractDto> contractPage = contractService.contractPage(
                "%" + cusName + "%",
                "%" + pawnItem + "%",
                types,
                startDay,
                endDay,
                "%" + status1 + "%",
                pageable);
        if (!contractPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractPage, HttpStatus.OK);
    }

    @GetMapping(value = "/listPage")
    public ResponseEntity<Page<ContractDto>> goListContract(@PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> code,
                                                            @RequestParam Optional<String> customerName, @RequestParam Optional<String> pawnItem,
                                                            @RequestParam Optional<String> startDate) {
        String keywordCode = code.orElse("");
        String keywordCustomerName = customerName.orElse("");
        String keywordPawnItem = pawnItem.orElse("");
        String keywordStartDate = startDate.orElse("0000-00-00");

        Page<ContractDto> contractPage = this.contractService.getAllContractPaginationAndSearch(pageable, keywordCode, keywordCustomerName, keywordPawnItem, keywordStartDate);
        if (contractPage.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractPage, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ContractDto> contractDetail(@PathVariable Long id) {
        ContractDto contract = contractService.findById(id);
        if (contract == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        contractService.deleteContract(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "returnItem/{id}")
    public ResponseEntity<Void> returnItem(@PathVariable long id, @RequestParam Optional<String> email, @RequestParam Optional<String> customerName) {
        String emailCustomer = email.orElse("");
        String keywordCustomerName = customerName.orElse("");
        this.contractService.returnItem(id);
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", MailConfig.HOST_NAME);
        props.put("mail.smtp.socketFactory.port", MailConfig.SSL_PORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", MailConfig.SSL_PORT);

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD);
            }
        });
        this.sendMailService.sendMailReturnItem(session, emailCustomer, keywordCustomerName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // duyên
    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createContract(@RequestBody @Valid ContractDtoHd contractDto,
                                                              BindingResult bindingResult) {
        contractDto.validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errMap = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(errMap, HttpStatus.BAD_REQUEST);
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contract.setItemPrice(Double.parseDouble(contractDto.getItemPrice()));
        contract.setInterestRate(Double.parseDouble(contractDto.getInterestRate()));
        contract.setStartDate(LocalDate.parse(contractDto.getStartDate()));
        contract.setEndDate(LocalDate.parse(contractDto.getEndDate()));
        contractService.saveContract(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
