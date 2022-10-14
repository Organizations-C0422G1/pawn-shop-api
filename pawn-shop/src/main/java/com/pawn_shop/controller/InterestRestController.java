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
@RequestMapping("/interestRest")
@CrossOrigin
public class InterestRestController {

    @Autowired
    private IContractService iContractService;

    @GetMapping("")
    public ResponseEntity<Page<Contract>> findAllHopDongByDate(@RequestParam(value = "startReturnDate") String startReturnDate,
                                                               @RequestParam(value = "endReturnDate") String endReturnDate,
                                                               @PageableDefault(size = 5) Pageable pageable) {
        Page<Contract> contracts = this.iContractService.findCompleteContractByDate(startReturnDate, endReturnDate, pageable);
        if (!contracts.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        }
    }
}
