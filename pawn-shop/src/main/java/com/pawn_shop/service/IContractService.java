package com.pawn_shop.service;

import com.pawn_shop.dto.projection.ContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<ContractDto> findAllContract(Pageable pageable, String code, String customerName, String pawnItem, String startDate);
}
