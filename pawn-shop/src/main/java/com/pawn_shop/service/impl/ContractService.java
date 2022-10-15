package com.pawn_shop.service.impl;

import com.pawn_shop.dto.projection.ContractDto;
import com.pawn_shop.repository.IContractRepository;
import com.pawn_shop.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<ContractDto> findAllContract(Pageable pageable, String code, String customerName, String pawnItem, String startDate) {
        return  this.contractRepository.findAllContract(pageable, code, customerName, pawnItem, startDate);
    }
}
