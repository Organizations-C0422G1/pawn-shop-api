package com.pawn_shop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pawn_shop.dto.projection.ContractProjection;
import com.pawn_shop.dto.projection.MailAutoProjection;
import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/contracts")
public class ContractRestController {
    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public ResponseEntity<Page<ContractProjection>> transactionHistory(
            @RequestParam Optional<String> customerName,
            @RequestParam Optional<String> pawnItemName,
            @RequestParam Optional<String> type,
            @RequestParam Optional<String> startDate,
            @RequestParam Optional<String> endDate,
            @RequestParam Optional<String> status,
            @PageableDefault(size = 20)Pageable pageable) {
        String types = type.orElse("");
        String cusName = customerName.orElse("");
        String pawnItem = pawnItemName.orElse("");
        String startDay = startDate.orElse("0000-00-00");
        String endDay = endDate.orElse("2032-01-01");
        String status1 = status.orElse("");
        Page<ContractProjection> contractPage = contractService.contractPage(
                "%"+ cusName + "%",
                "%" + pawnItem + "%",
                types,
                startDay,
                endDay,
                "%" + status1 + "%",
                pageable);
        if (!contractPage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> contractDetail(@PathVariable Long id){
        Contract contract = contractService.findById(id);
        if (contract == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id){
        contractService.deleteContract(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
