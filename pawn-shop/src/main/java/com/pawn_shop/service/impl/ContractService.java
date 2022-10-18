package com.pawn_shop.service.impl;

import com.pawn_shop.repository.IContractRepository;
import com.pawn_shop.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;
    @Override
    public void updateStatusContract(Long idContract) {
        iContractRepository.updateStatusContract(idContract);
    }
}
