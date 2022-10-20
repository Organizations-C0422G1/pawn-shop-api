package com.pawn_shop.controller;

import com.pawn_shop.dto.ContractDto;
import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class RestContractController {
    @Autowired
    private IContractService iContractService;

    @GetMapping("/list/contract")
    public ResponseEntity<List<Contract>> findAllContract() {
        List<Contract> contractList = iContractService.findAllContract();
        if (contractList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractList, HttpStatus.OK);
    }

    @PostMapping("/contract/create")
    public ResponseEntity<Map<String, String>> createContract(@RequestBody @Valid ContractDto contractDto, BindingResult bindingResult) {
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
        iContractService.saveContract(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
