package com.pawn_shop.repository;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;

public interface IContractRepository extends JpaRepository<Contract, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into contract (code,end_date,interest_rate,item_price,liquidation_price,return_date,start_date,status,customer_id,employee_id," +
            "pawn_item_id,`type`) value (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12)", nativeQuery = true)
    void saveContract(String code, LocalDate endDate, Double interestRate, Double itemPrice, Double liquidationPrice, LocalDate returnDate, LocalDate startDate, int status, Long customerId, Long employeeId, Long pawnItemId, boolean type);
}
