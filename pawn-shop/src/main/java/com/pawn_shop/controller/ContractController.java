package com.pawn_shop.controller;
import com.pawn_shop.dto.ContractDto;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<?> update(@Valid  @RequestBody ContractDto contractDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            iContractService.updateContract(contract);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
