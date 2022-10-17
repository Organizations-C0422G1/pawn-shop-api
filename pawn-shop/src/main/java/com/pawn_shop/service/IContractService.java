package com.pawn_shop.service;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IContractService {

    List<Contract> findAllContract();

    List<Contract> top10Contract();

    void updateContract(Contract contract);

    Contract findIdContract(Long id);


}
