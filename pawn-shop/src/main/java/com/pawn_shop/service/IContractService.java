package com.pawn_shop.service;

import com.pawn_shop.dto.projection.ContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IContractService {
    Page<ContractDto> getAllContractPaginationAndSearch(Pageable pageable, String code, String customerName, String pawnItem, String startDate);

    Optional<ContractDto> getContractDtoById(long id);

    void deleteContract(long id);
}
