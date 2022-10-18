package com.pawn_shop.repository;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IContractRepository extends JpaRepository<Contract, Long> {
    @Modifying
    @Query(value = "UPDATE `pawn_shop`.`contract` SET `status` = '2' WHERE (`id` = :idContract)", nativeQuery = true)
    void updateStatusContract(@Param("idContract") Long idContract);

}
