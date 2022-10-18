package com.pawn_shop.repository;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IContractRepository extends JpaRepository<Contract, Long> {

    @Query(value = "select id,\n" +
            "   code,\n" +
            "   item_price,\n" +
            "   interest_rate,\n" +
            "   start_date,\n" +
            "   end_date,\n" +
            "   return_date,\n" +
            "   status,\n" +
            "   `type`,\n" +
            "   liquidation_price,\n" +
            "   customer_id,\n" +
            "   employee_id,\n" +
            "   pawn_item_id from contract where contract.status = 1", nativeQuery = true,
            countQuery = "select count(*) from contract where contract.status = 1")
    Page<Contract> findAllCompleteContract(Pageable pageable);


    @Query(value = "select id,\n" +
            "   code,\n" +
            "   item_price,\n" +
            "   interest_rate,\n" +
            "   start_date,\n" +
            "   end_date,\n" +
            "   return_date,\n" +
            "   status,\n" +
            "   `type`,\n" +
            "   liquidation_price,\n" +
            "   customer_id,\n" +
            "   employee_id,\n" +
            "   pawn_item_id from contract where (start_date between :startReturnDate  and :endReturnDate) and `status` = 1", nativeQuery = true,
            countQuery = "select count(*) from contract where (start_date between :startReturnDate  and :endReturnDate) and `status` = 1")
    Page<Contract> findCompleteContractByDate(@Param("startReturnDate") String startReturnDate,
                                              @Param("endReturnDate") String endReturnDate, Pageable pageable);

    @Query(value = "select id,\n" +
            "   code,\n" +
            "   item_price,\n" +
            "   interest_rate,\n" +
            "  start_date,\n" +
            "  end_date,\n" +
            "  return_date,\n" +
            "   status,\n" +
            "   `type`,\n" +
            "   liquidation_price,\n" +
            "   customer_id,\n" +
            "   employee_id,\n" +
            "   pawn_item_id from contract where `status` = 3", nativeQuery = true,
            countQuery = "select count(*) from contract where `status` = 3")
    Page<Contract> findAllLiquidatedContract(Pageable pageable);


    @Query(value = "select id,\n" +
            "   code,\n" +
            "   item_price,\n" +
            "   interest_rate,\n" +
            "  start_date,\n" +
            "  end_date,\n" +
            "  return_date,\n" +
            "   status,\n" +
            "   `type`,\n" +
            "   liquidation_price,\n" +
            "   customer_id,\n" +
            "   employee_id,\n" +
            "   pawn_item_id from contract where (start_date between :startReturnDate  and :endReturnDate) and `status` = 3", nativeQuery = true,
            countQuery = "select count(*) from contract where (start_date between :startReturnDate  and :endReturnDate) and `status` = 3")
    Page<Contract> findLiquidatedContractByDate(@Param("startReturnDate") String startReturnDate,
                                                @Param("endReturnDate") String endReturnDate, Pageable pageable);

    @Query(value = "select id,\n" +
            "   code,\n" +
            "   item_price,\n" +
            "   interest_rate,\n" +
            "  start_date,\n" +
            "  end_date,\n" +
            "  return_date,\n" +
            "   status,\n" +
            "   `type`,\n" +
            "   liquidation_price,\n" +
            "   customer_id,\n" +
            "   employee_id,\n" +
            "   pawn_item_id from contract where `status` = 0", nativeQuery = true,
            countQuery = "select count(*) from contract where `status` = 0")
    Page<Contract> findAllExpectedContract(Pageable pageable);


    @Query(value = "select id,\n" +
            "   code,\n" +
            "   item_price,\n" +
            "   interest_rate,\n" +
            "  start_date,\n" +
            "  end_date,\n" +
            "  return_date,\n" +
            "   status,\n" +
            "   `type`,\n" +
            "   liquidation_price,\n" +
            "   customer_id,\n" +
            "   employee_id,\n" +
            "   pawn_item_id from contract where (start_date between :startReturnDate  and :endReturnDate) and `status` = 0", nativeQuery = true,
            countQuery = "select count(*) from contract where (start_date between :startReturnDate  and :endReturnDate) and `status` = 0")
    Page<Contract> findExpectedContractByDate(@Param("startReturnDate") String startReturnDate,
                                              @Param("endReturnDate") String endReturnDate, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `pawn_shop`.`contract` SET `status` = '2' WHERE (`id` = :idContract)", nativeQuery = true)
    void updateStatusContract(@Param("idContract") Long idContract);


}
