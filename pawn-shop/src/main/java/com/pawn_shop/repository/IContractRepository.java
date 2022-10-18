package com.pawn_shop.repository;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface IContractRepository extends JpaRepository<Contract, Long> {

    @Modifying
    @Query(nativeQuery = true,value = "UPDATE `pawn_shop`.`contract` \n" +
            "SET \n" +
            "    `liquidation_price` = ?1,\n" +
            "    `return_date` = ?2,\n" +
            "    `status` = 3 \n" +
            "WHERE\n" +
            "    (`id` = ?3);\n")
    void createLiquidation(Double price, String dateLiquidation, Long idContract);
}
