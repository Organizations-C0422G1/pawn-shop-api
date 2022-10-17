package com.pawn_shop.service.impl;

<<<<<<< HEAD
=======
import com.pawn_shop.dto.projection.ContractProjection;
import com.pawn_shop.dto.projection.MailAutoProjection;
>>>>>>> eeb286226d59101534b1f2e70a8e8b4048d17b2f
import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.repository.IContractRepository;
import com.pawn_shop.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
<<<<<<< HEAD

import java.time.LocalDate;
=======
import org.springframework.stereotype.Service;
>>>>>>> eeb286226d59101534b1f2e70a8e8b4048d17b2f

import java.time.LocalDate;
import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
<<<<<<< HEAD
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
=======

    @Override
    public Page<ContractProjection> contractPage(String customerName,
                                                 String pawnItemName,
                                                 String type,
                                                 String startDate,
                                                 String endDate,
                                                 String status,
                                                 Pageable pageable) {
        if (type.equals("")) {
            return contractRepository.contractPage(
                    customerName,
                    pawnItemName,
                    1,
                    0,
                    startDate,
                    endDate,
                    status,
                    pageable);
        } else if (type.equals("1")) {
            return contractRepository.contractPage(
                    customerName,
                    pawnItemName,
                    1,
                    1,
                    startDate,
                    endDate,
                    status,
                    pageable);
        }
        return contractRepository.contractPage(
                customerName,
                pawnItemName,
                0,
                0,
                startDate,
                endDate,
                status,
                pageable);
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findByIdContract(id);
    }

    @Override
    public void deleteContract(Long id) {
        contractRepository.deleteContract(id);
>>>>>>> eeb286226d59101534b1f2e70a8e8b4048d17b2f
    }
}
