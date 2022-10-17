package com.pawn_shop.repository;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract, Long> {

    @Query(nativeQuery = true,value = "UPDATE `pawn_shop`.`contract` SET `liquidation_price` = ?1, `return_date` = ?2" +
            " WHERE `customer_id` = ?3 and `pawn_item_id` = ?4;")
    void createLiquidation(Double price, String dateLiquidation, Long idCustomer,Long idPawnItem);
}
