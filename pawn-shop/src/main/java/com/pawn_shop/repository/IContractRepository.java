package com.pawn_shop.repository;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;

@Transactional
public interface IContractRepository extends JpaRepository<Contract, Long> {
    @Query(nativeQuery = true, value = "select ct.*" +
            " from contract ct right join customer c " +
            " on ct.customer_id = c.id right join pawn_item p on ct.pawn_item_id = p.id right join pawn_type pt on pt.id = p.pawn_type_id where c.name like ?1 and " +
            " p.name like ?2 and ( ct.type = ?3 or ct.type = ?4 ) and ct.start_date >= ?5 and ct.end_date <= ?6 and ct.status like ?7 and ct.status <> 5 ",

            countQuery = "select ct.* " +
                    "from contract ct right join customer c " +
                    "on ct.customer_id = c.id right join pawn_item p on ct.pawn_item_id = p.id right join pawn_type pt on pt.id = p.pawn_type_id where c.name like ?1 and " +
                    "p.name like ?2 and ( ct.type = ?3 or ct.type = ?4 ) and ct.start_date >= ?5 and ct.end_date <= ?6 and ct.status like ?7 and ct.status <> 5 ")
    public Page<Contract> contractPage(String customerName,
                                       String pawnItemName,
                                       int type,
                                       int type1,
                                       String startDate,
                                       String endDate,
                                       String status,
                                       Pageable pageable);

    @Query(nativeQuery = true, value = "select ct.* from contract ct right join customer c " +
            "on ct.customer_id = c.id right join pawn_item p on ct.pawn_item_id = p.id right join pawn_type pt on pt.id = p.pawn_type_id where ct.id = ?1 and ct.status <> 5 ")
    public Contract findByIdContract(Long id);

    @Modifying
    @Query(nativeQuery = true, value = "update contract ct set ct.status = 5 where ct.id = ?1")
    public void deleteContract(Long id);
}
