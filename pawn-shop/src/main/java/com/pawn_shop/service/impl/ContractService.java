package com.pawn_shop.service.impl;

import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.repository.IContractRepository;
import com.pawn_shop.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public List<Contract> findAllContract() {
        return iContractRepository.findAllContract();
    }

    @Override
    public List<Contract> top10Contract() {
        return iContractRepository.top10Contract();
    }

    @Override
    public void updateContract(Contract contract) {
        iContractRepository.updateContract(contract.getCode(),contract.getEndDate(),contract.getInterestRate(),
                contract.getItemPrice(),contract.getLiquidationPrice(),contract.getReturnDate(),contract.getStartDate(),
                contract.getType(),contract.getCustomer().getId(),contract.getEmployee().getId(),contract.getPawnItem().getId(), contract.getId());
    }


    @Override
    public Contract findIdContract(Long id) {
        return iContractRepository.findIdContract(id);
    }
}
