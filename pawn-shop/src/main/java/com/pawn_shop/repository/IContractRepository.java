package com.pawn_shop.repository;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract, Long> {

    @Query(value = "select * from contract where `status` = 1", nativeQuery = true,
            countQuery = "select count(*) from contract where `status` = 1")
    Page<Contract> findAllCompleteContract(Pageable pageable);


    @Query(value = "select * from contract where (return_date between :startReturnDate  and :endReturnDate) and `status` = 1", nativeQuery = true)
    Page<Contract> findCompleteContractByDate(@Param("startReturnDate") String startReturnDate,
                                              @Param("endReturnDate") String endReturnDate, Pageable pageable);
}
