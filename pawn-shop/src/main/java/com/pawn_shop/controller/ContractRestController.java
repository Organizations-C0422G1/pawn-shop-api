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
@RequestMapping(value = "/contractRest")
public class ContractRestController {
    @Autowired
    private IContractService contractService;

    @GetMapping(value = "/listPage")
    public ResponseEntity<Page<ContractDto>> goListContract(@PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> code,
                                                         @RequestParam Optional<String> customerName, @RequestParam Optional<String> pawnItem,
                                                         @RequestParam Optional<String> startDate) {
        String keywordCode = code.orElse("");
        String keywordCustomerName = customerName.orElse("");
        String keywordPawnItem = pawnItem.orElse("");
        String keywordStartDate = startDate.orElse("");

        Page<ContractDto> contractPage = this.contractService.findAllContract(pageable, keywordCode, keywordCustomerName, keywordPawnItem, keywordStartDate);
        if (contractPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractPage, HttpStatus.OK);
    }
}
