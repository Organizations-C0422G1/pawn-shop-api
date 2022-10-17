package com.pawn_shop.service;

import com.pawn_shop.dto.projection.ContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<ContractDto> contractPage(String customerName,
                                   String pawnItemName,
                                   String type,
                                   String startDate,
                                   String endDate,
                                   String status,
                                   Pageable pageable);

    ContractDto findById(Long id);

    void deleteContract(Long id);
}
