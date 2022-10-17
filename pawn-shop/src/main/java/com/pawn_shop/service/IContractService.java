package com.pawn_shop.service;

<<<<<<< HEAD
import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface IContractService {
    Page<Contract> contractPage(String customerName,
                                String pawnItemName,
                                int status,
                                LocalDate startDate,
                                LocalDate endDate,
                                Pageable pageable);
=======
import com.pawn_shop.dto.projection.ContractProjection;
import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<ContractProjection> contractPage(String customerName,
                                          String pawnItemName,
                                          String type,
                                          String startDate,
                                          String endDate,
                                          String status,
                                          Pageable pageable);

    Contract findById(Long id);

    void deleteContract(Long id);
>>>>>>> eeb286226d59101534b1f2e70a8e8b4048d17b2f
}
