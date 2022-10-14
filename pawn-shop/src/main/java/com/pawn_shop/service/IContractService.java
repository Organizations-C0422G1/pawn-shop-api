package com.pawn_shop.service;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {

    Page<Contract> findCompleteContractByDate(String startReturnDate, String endReturnDate, Pageable pageable);
}
