package com.pawn_shop.controller;

import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee/interestRest")
@CrossOrigin
public class InterestRestController {

    @Autowired
    private IContractService iContractService;

    @GetMapping("/complete-contract")
    public ResponseEntity<Page<Contract>> findCompleteContractByDate(@RequestParam(value = "startReturnDate") String startReturnDate,
                                                                     @RequestParam(value = "endReturnDate") String endReturnDate,
                                                                     @PageableDefault(size = 5) Pageable pageable) {
        if (endReturnDate.compareTo(startReturnDate) < 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            Page<Contract> contracts = this.iContractService.findCompleteContractByDate(startReturnDate, endReturnDate, pageable);
        if (!contracts.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        }
    }

    @GetMapping("/liquidation-contract")
    public ResponseEntity<Page<Contract>> findLiquidationContractByDate(@RequestParam(value = "startReturnDate") String startReturnDate,
                                                                        @RequestParam(value = "endReturnDate") String endReturnDate,
                                                                        @PageableDefault(size = 5) Pageable pageable) {
        if (endReturnDate.compareTo(startReturnDate) < 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Page<Contract> contracts = this.iContractService.findLiquidationContractByDate(startReturnDate, endReturnDate, pageable);
        if (!contracts.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        }
    }

    @GetMapping("/expected-contract")
    public ResponseEntity<Page<Contract>> findExpectedContractByDate(@RequestParam(value = "startReturnDate") String startReturnDate,
                                                                     @RequestParam(value = "endReturnDate") String endReturnDate,
                                                                     @PageableDefault(size = 5) Pageable pageable) {
        if (endReturnDate.compareTo(startReturnDate) < 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Page<Contract> contracts = this.iContractService.findExpectedContractByDate(startReturnDate, endReturnDate, pageable);
        if (!contracts.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> findContractById(@PathVariable Long id) {
        Contract contract = this.iContractService.findById(id);
        if (contract == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }


}
