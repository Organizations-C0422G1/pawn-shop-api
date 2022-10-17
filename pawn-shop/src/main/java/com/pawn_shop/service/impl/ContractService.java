package com.pawn_shop.service.impl;

import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.repository.IContractRepository;
import com.pawn_shop.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public Page<Contract> contractPage(String customerName,
                                       String pawnItemName,
                                       int status,
                                       LocalDate startDate,
                                       LocalDate endDate,
                                       Pageable pageable) {
        return contractRepository.contractPage(
                "%" + customerName + "%",
                "%" + pawnItemName + "%",)
    }
}
