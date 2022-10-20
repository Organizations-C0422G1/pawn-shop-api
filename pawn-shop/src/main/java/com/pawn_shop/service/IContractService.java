package com.pawn_shop.service;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findCompleteContractByDate(String startReturnDate, String endReturnDate, Pageable pageable);

    Contract findById(Long id);

    Page<Contract> findLiquidationContractByDate(String startReturnDate, String endReturnDate, Pageable pageable);

    Page<Contract> findExpectedContractByDate(String startReturnDate, String endReturnDate, Pageable pageable);

    <T> List<T> getAllExpectedContractByDate(String startReturnDate, String endReturnDate, Class<T> tClass);

    <T> List<T> getAllLiquidationContractByDate(String startReturnDate, String endReturnDate, Class<T> tClass);

    <T> List<T> getAllCompleteContractByDate(String startReturnDate, String endReturnDate, Class<T> tClass);



}
