package com.pawn_shop.service;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> contractPage(String customerName,
                                String pawnItemName,
                                String type,
                                String startDate,
                                String endDate,
                                String status,
                                Pageable pageable);

    Contract findById(Long id);

    void deleteContract(Long id);
}
