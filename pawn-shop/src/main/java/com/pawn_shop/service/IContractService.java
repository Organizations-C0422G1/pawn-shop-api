package com.pawn_shop.service;

import com.pawn_shop.model.contract.Contract;

import java.util.List;

public interface IContractService {
    void saveContract(Contract contract);
    List<Contract> findAllContract();
}
