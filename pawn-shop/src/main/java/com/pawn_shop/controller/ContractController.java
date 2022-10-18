package com.pawn_shop.controller;
import com.pawn_shop.dto.ContractUpdateDto;
import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.service.IContractService;
import com.pawn_shop.service.ICustomerService;
import com.pawn_shop.service.IPawnItemService;
import com.pawn_shop.service.IPawnTypeService;
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
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ContractController {

    @Autowired
    private IContractService iContractService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IPawnTypeService iPawnTypeService;
    @Autowired
   private IPawnItemService iPawnItemService;

    @GetMapping("/customerlist")
    public ResponseEntity<?> getAllCustomerService() {
        return new ResponseEntity<>(iCustomerService.findAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/top10Contract")
    public ResponseEntity<?> top10Contract() {
        return new ResponseEntity<>(iContractService.top10Contract(), HttpStatus.OK);
    }

    @GetMapping("/pawntypelist")
    public ResponseEntity<?> getAllPawnType() {
        return new ResponseEntity<>(iPawnTypeService.findAllPawnType(), HttpStatus.OK);
    }

    @GetMapping("/pawnitemlist")
    public ResponseEntity<?> getAllPawnItem() {
        return new ResponseEntity<>(iPawnItemService.findAllPawnItem(), HttpStatus.OK);
    }

    @GetMapping("/contract/{id}")
    public ResponseEntity<?> getId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iContractService.findIdContract(id), HttpStatus.OK);
    }

    @PatchMapping(value = "/update-contract", consumes = {"*/*"})
    public ResponseEntity<Map<String, String>> update(@Valid  @RequestBody ContractUpdateDto contractUpdateDto, BindingResult bindingResult) {
     contractUpdateDto.validate(contractUpdateDto,bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errMap = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractUpdateDto, contract);
            contract.setItemPrice(Double.parseDouble(contractUpdateDto.getItemPrice()));
            contract.setInterestRate(Double.parseDouble(contractUpdateDto.getInterestRate()));
            contract.setStartDate(LocalDate.parse(contractUpdateDto.getStartDate()));
            contract.setEndDate(LocalDate.parse(contractUpdateDto.getEndDate()));
            iContractService.updateContract(contract);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
