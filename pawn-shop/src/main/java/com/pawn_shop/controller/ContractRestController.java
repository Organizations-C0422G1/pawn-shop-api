package com.pawn_shop.controller;

import com.pawn_shop.dto.projection.ContractDto;
import com.pawn_shop.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/employee/contracts")
public class ContractRestController {
    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public ResponseEntity<Page<ContractDto>> transactionHistory(
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
        Page<ContractDto> contractPage = contractService.contractPage(
                "%"+ cusName + "%",
                "%" + pawnItem + "%",
                types,
                startDay,
                endDay,
                "%" + status1 + "%",
                pageable);
        if (!contractPage.hasContent()){
        
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
    public ResponseEntity<ContractDto> contractDetail(@PathVariable Long id){
        ContractDto contract = contractService.findById(id);
        if (contract == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id){
        contractService.deleteContract(id);

    @PatchMapping(value = "returnItem/{id}")
    public ResponseEntity<Void> returnItem(@PathVariable long id) {
        this.contractService.returnItem(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
