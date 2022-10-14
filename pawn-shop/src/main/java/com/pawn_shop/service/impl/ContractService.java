package com.pawn_shop.service.impl;

import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.repository.IContractRepository;
import com.pawn_shop.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;


    @Override
    public Page<Contract> findCompleteContractByDate(String startReturnDate, String endReturnDate, Pageable pageable) {
        if (startReturnDate.equals("") && endReturnDate.equals("")) {
            return iContractRepository.findAll(pageable);
        } else {
            return iContractRepository.findCompleteContractByDate(startReturnDate, endReturnDate, pageable);
        }
    }
}
