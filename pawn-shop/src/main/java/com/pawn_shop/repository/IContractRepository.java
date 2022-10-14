package com.pawn_shop.repository;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract, Long> {
//    @Query (value = "insert into contract (code,end_date,interest_rate,item_price,)")
}
