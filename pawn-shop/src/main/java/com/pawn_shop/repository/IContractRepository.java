package com.pawn_shop.repository;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
public interface IContractRepository extends JpaRepository<Contract, Long> {
    @Query(nativeQuery = true, value = "select ct.code, c.name as customer_name, p.name as pawn_item_name, pt.name as type_pawn, ct.end_date, ct.status" +
            " from contract ct join customer c" +
            "on ct.customer_id = c.id join pawn_item p on ct.pawn_item_id = p.id where c.name like ?1 and " +
            "p.name like ?2 and ct.status = ?3 and ct.start_date >= ?4 and ct.end_date <= ?5",
    countQuery = "select ct.code, c.name as customer_name, p.name as pawn_item_name, pt.name as type_pawn, ct.end_date, ct.status " +
            "from contract ct join customer c" +
            "on ct.customer_id = c.id join pawn_item p on ct.pawn_item_id = p.id where c.name like ?1 and " +
            "p.name like ?2 and ct.status = ?3 and ct.start_date >= ?4 and ct.end_date <= ?5")
    public Page<Contract> contractPage(String customerName,
                                       String pawnItemName,
                                       int status,
                                       LocalDate startDate,
                                       LocalDate endDate,
                                       Pageable pageable);
}
