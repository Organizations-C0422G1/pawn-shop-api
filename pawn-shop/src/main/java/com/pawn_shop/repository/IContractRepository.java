package com.pawn_shop.repository;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface IContractRepository extends JpaRepository<Contract, Long> {

    @Modifying
    @Query(nativeQuery = true,value = "UPDATE `pawn_shop`.`contract` " +
            "SET " +
            "    `liquidation_price` = ?1," +
            "    `return_date` = ?2," +
            "    `status` = 3 " +
            "WHERE" +
            "    (`id` = ?3);")
    void createLiquidation(Double price, String dateLiquidation, Long idContract);

    @Query(value = "select c.id from contract c" +
            " where c.pawn_item_id = ?1",nativeQuery = true)
    Long findContractByIdPawnItem(Long idPawnItem);
}
