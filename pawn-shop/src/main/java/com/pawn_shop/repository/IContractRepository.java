package com.pawn_shop.repository;

import com.pawn_shop.dto.projection.ContractDto;
import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IContractRepository extends JpaRepository<Contract, Long> {
    @Query(value = "select ct.code, ct.item_price as itemPrice, ct.interest_rate as interestRate, " +
            " ct.start_date as startDate, ct.end_date as endDate, ct.return_date as returnDate," +
            " ct.liquidation_price as liquidationPrice, pi.name as pawnItem," +
            " c.name as customer from contract ct " +
            " join customer c on ct.customer_id = c.id " +
            " join pawn_item pi on ct.pawn_item_id = pi.id " +
            " where (ct.code like %:code% and c.name like %:customerName% and pi.name like %:pawnItem% and ct.start_date like %:startDate) " +
            " and ct.status = 0", nativeQuery = true,
    countQuery = "select count(*) from (" +
            "select ct.code, ct.item_price as itemPrice, ct.interest_rate as interestRate, " +
            "            ct.start_date as startDate, ct.end_date as endDate, ct.return_date as returnDate, " +
            "            ct.liquidation_price as liquidationPrice, pi.name as pawnItem, " +
            "            c.name as customer from contract ct " +
            "            join customer c on ct.customer_id = c.id " +
            "            join pawn_item pi on ct.pawn_item_id = pi.id " +
            "            where (ct.code like %:code% and c.name like %:customerName% and pi.name like %:pawnItem% and ct.start_date like %:startDate) " +
            "            and ct.status = 0) contract")
    Page<ContractDto> findAllContract(Pageable pageable, @Param("code") String code, @Param("customerName") String customerName,
                                      @Param("pawnItem") String pawnItem, @Param("startDate") String startDate);
}
