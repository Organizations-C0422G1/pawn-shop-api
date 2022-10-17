package com.pawn_shop.repository;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


public interface IContractRepository extends JpaRepository<Contract, Long> {

    @Modifying
    @Transactional
    @Query(value = "update contract set code = :code , end_date = :endDate, interest_rate = :interestRate, item_price = :itemPrice," +
            "liquidation_price = :liquidationPrice, return_date = :returnDate,start_date = :startDate, type = :type," +
            "customer_id = :customerId, employee_id = :employeeId, pawn_item_id = :pawnItemId where id = :id ", nativeQuery = true)
    void updateContract(@Param("code") String code, @Param("endDate")LocalDate endDate,@Param("interestRate") Double interestDate,
                        @Param("itemPrice") Double itemPrice, @Param("liquidationPrice") Double liquidationPrice,@Param("returnDate") LocalDate returnDate ,
                        @Param("startDate") LocalDate startDate, @Param("type") Boolean type,
                        @Param("customerId") Long customerId, @Param("employeeId") Long employeeId,
                        @Param("pawnItemId") Long pawnItemId, @Param("id") Long id);

    @Query(value = "select  * from contract where start_date = current_date order  by id desc limit 10", nativeQuery = true)
    List<Contract> top10Contract();

    @Query(value = "select  * from contract where status_delete = 0", nativeQuery = true)
    List<Contract> findAllContract();


    @Query(value = "select * from contract where id = :id",nativeQuery = true)
    Contract findIdContract(@Param("id") Long id);


}
