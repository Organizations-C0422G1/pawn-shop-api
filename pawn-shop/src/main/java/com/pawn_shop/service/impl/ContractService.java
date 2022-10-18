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
    public void createLiquidation(Double price, String dateLiquidation, Long idContract) {
        iContractRepository.createLiquidation(price, dateLiquidation, idContract);
    }

    @Override
    public Long findContractByIdPawnItem(Long idPawnItem) {
        return iContractRepository.findContractByIdPawnItem(idPawnItem);
    }
}
