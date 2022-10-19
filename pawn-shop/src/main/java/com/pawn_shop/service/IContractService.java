package com.pawn_shop.service;

import com.pawn_shop.dto.projection.ContractDto;
import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

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

    Page<ContractDto> getAllContractPaginationAndSearch(Pageable pageable, String code, String customerName, String pawnItem, String startDate);

    void returnItem(Double liquidationPrice, LocalDate returnDate, long id);

    void saveContract(Contract contract);

    List<Contract> findAllContract();

    List<Contract> top10Contract();

    void updateContract(Contract contract);

    Contract findIdContract(Long id);

    Contract createQuickContract(Contract contract);

    Contract findContract();
}
