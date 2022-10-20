package com.pawn_shop.service.impl;


import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.repository.IContractRepository;
import com.pawn_shop.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findCompleteContractByDate(String startReturnDate, String endReturnDate, Pageable pageable) {
        if (startReturnDate.equals("") && endReturnDate.equals("")) {
            return iContractRepository.findAllCompleteContract(pageable);
        } else {
            return iContractRepository.findCompleteContractByDate(startReturnDate, endReturnDate, pageable);
        }
    }

    @Override
    public Contract findById(Long id) {
        return this.iContractRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Contract> findLiquidationContractByDate(String startReturnDate, String endReturnDate, Pageable pageable) {
        if (startReturnDate.equals("") && endReturnDate.equals("")) {
            return iContractRepository.findAllLiquidatedContract(pageable);
        } else {
            return iContractRepository.findLiquidatedContractByDate(startReturnDate, endReturnDate, pageable);
        }
    }

    @Override
    public Page<Contract> findExpectedContractByDate(String startReturnDate, String endReturnDate, Pageable pageable) {
        if (startReturnDate.equals("") && endReturnDate.equals("")) {
            return iContractRepository.findAllExpectedContract(pageable);
        } else {
            return iContractRepository.findExpectedContractByDate(startReturnDate, endReturnDate, pageable);
        }
    }

    @Override
    public <T> List<T> getAllExpectedContractByDate(String startReturnDate, String endReturnDate, Class<T> tClass) {
        if (startReturnDate.equals("") && endReturnDate.equals("")) {
            return iContractRepository.getAllExpectedContract(tClass);
        } else {
            return iContractRepository.getAllExpectedContractByDate(startReturnDate, endReturnDate, tClass);
        }

    }

    @Override
    public <T> List<T> getAllLiquidationContractByDate(String startReturnDate, String endReturnDate, Class<T> tClass) {
        if (startReturnDate.equals("") && endReturnDate.equals("")) {
            return iContractRepository.getAllLiquidationContract(tClass);
        } else {
            return iContractRepository.getAllLiquidationContractByDate(startReturnDate, endReturnDate, tClass);
        }
    }

    @Override
    public <T> List<T> getAllCompleteContractByDate(String startReturnDate, String endReturnDate, Class<T> tClass) {
        if (startReturnDate.equals("") && endReturnDate.equals("")) {
            return iContractRepository.getAllCompleteContract(tClass);
        } else {
            return iContractRepository.getAllCompleteContractByDate(startReturnDate, endReturnDate, tClass);
        }
    }

    @Override
    public void updateStatusContract(Long idContract) {
        iContractRepository.updateStatusContract(idContract);
    }
}
