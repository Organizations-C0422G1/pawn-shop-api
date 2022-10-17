package com.pawn_shop.service;

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
}
