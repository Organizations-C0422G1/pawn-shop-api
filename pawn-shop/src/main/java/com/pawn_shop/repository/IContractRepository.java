package com.pawn_shop.repository;

import com.pawn_shop.dto.projection.ContractDto;
import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IContractRepository extends JpaRepository<Contract, Long> {
    @Query(value = "select ct.code, c.name as customer, pi.name as pawnItem, " +
            "ct.item_price as itemPrice, ct.start_date as startDate " +
            " from contract ct " +
            " join customer c on ct.customer_id = c.id " +
            " join pawn_item pi on ct.pawn_item_id = pi.id " +
            " where (ct.code like %:code% and c.name like %:customerName% " +
            " and pi.name like %:pawnItem% and ct.start_date like %:startDate) " +
            " and ct.status = 0", nativeQuery = true,
            countQuery = "select count(*) from (" +
                    "select ct.code, c.name as customer, pi.name as pawnItem, " +
                    " ct.item_price as itemPrice, ct.start_date as startDate " +
                    " from contract ct " +
                    " join customer c on ct.customer_id = c.id " +
                    " join pawn_item pi on ct.pawn_item_id = pi.id " +
                    " where (ct.code like %:code% and c.name like %:customerName% " +
                    " and pi.name like %:pawnItem% and ct.start_date like %:startDate) " +
                    " and ct.status = 0) contracts")
    Page<ContractDto> getAllContractPaginationAndSearch(Pageable pageable, @Param("code") String code, @Param("customerName") String customerName,
                                                        @Param("pawnItem") String pawnItem, @Param("startDate") String startDate);

    @Query(value = "select ct.code, c.name as customer, pi.name as pawnItem, " +
            " ct.item_price as itemPrice, ct.interest_rate as interestRate, " +
            " ct.start_date as startDate, ct.end_date as endDate, ct.return_date as returnDate, " +
            " ct.liquidation_price as liquidationPrice " +
            " from contract ct " +
            " join customer c on ct.customer_id = c.id " +
            " join pawn_item pi on ct.pawn_item_id = pi.id " +
            " where ct.id = :id and ct.status = 0", nativeQuery = true)
    Optional<ContractDto> getContractDtoById(@Param("id") long id);

    @Modifying
    @Query(value = "update contract set status = 1 where id = :id", nativeQuery = true)
    void deleteContract(@Param("id") long id);
}