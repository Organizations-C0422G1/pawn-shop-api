package com.pawn_shop.repository;

import com.pawn_shop.dto.projection.ContractDto;
import com.pawn_shop.dto.projection.MailAutoProjection;
import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
public interface IContractRepository extends JpaRepository<Contract, Long> {
    @Query(nativeQuery = true, value = "select ct.id as id, ct.code as code, c.name as customer, p.name as pawnItem, " +
            "pt.name as pawnTypeName, ct.start_date as startDate, ct.end_date as endDate, ct.type as type, ct.status as status " +
            " from contract ct right join customer c " +
            " on ct.customer_id = c.id right join pawn_item p on ct.pawn_item_id = p.id right join pawn_type pt on pt.id = p.pawn_type_id where c.name like ?1 and " +
            " p.name like ?2 and ( ct.type = ?3 or ct.type = ?4 ) and ct.start_date >= ?5 and ct.end_date <= ?6 and ct.status like ?7 and ct.status <> 5 ",

            countQuery = "select ct.id as id, ct.code as code, c.name as customer, p.name as pawnItem, " +
                    "pt.name as pawnTypeName, ct.start_date as startDate, ct.end_date as endDate, ct.type as type, ct.status as status " +
                    "from contract ct right join customer c " +
                    "on ct.customer_id = c.id right join pawn_item p on ct.pawn_item_id = p.id right join pawn_type pt on pt.id = p.pawn_type_id where c.name like ?1 and " +
                    "p.name like ?2 and ( ct.type = ?3 or ct.type = ?4 ) and ct.start_date >= ?5 and ct.end_date <= ?6 and ct.status like ?7 and ct.status <> 5 ")
    public Page<ContractDto> contractPage(String customerName,
                                          String pawnItemName,
                                          int type,
                                          int type1,
                                          String startDate,
                                          String endDate,
                                          String status,
                                          Pageable pageable);

    @Query(nativeQuery = true, value = "select ct.id as id, ct.code as code, c.name as customer, " +
            "ct.start_date as startDate, ct.end_date as endDate, " +
            "p.name as pawnItem, e.name as employee, ct.type as type, " +
            "c.email as customerEmail, ct.item_price as itemPrice, " +
            "ct.status as status, ct.return_date as returnDate, " +
            "ct.interest_rate as interestRate, ct.liquidation_price as liquidationPrice " +
            "from contract ct join customer c on ct.customer_id = c.id " +
            "join pawn_item p on ct.pawn_item_id = p.id " +
            "join pawn_type pt on pt.id = p.pawn_type_id " +
            "join employee e on ct.employee_id = e.id " +
            "where ct.id = ?1 and ct.status <> 5 ")
    public ContractDto findByIdContractDto(Long id);

    @Modifying
    @Query(nativeQuery = true, value = "update contract ct set ct.status = 5 where ct.id = ?1")
    public void deleteContract(Long id);

    @Query(nativeQuery = true, value = "select ct.code as code, ct.start_date as startDate, ct.end_date as endDate, c.name as customerName, c.email as customerEmail, pt.name as pawnItemName " +
            "from contract ct right join customer c on ct.customer_id = c.id right join pawn_item pt on " +
            "ct.pawn_item_id = pt.id where ( ct.end_date = ?1 or ct.end_date = ?2 or ct.end_date = ?3 or ct.end_date = ?4 ) and ct.status <> 5 ")
    public List<MailAutoProjection> listEmailAutoSend(LocalDate beforeOneDay,
                                                      LocalDate beforeThreeDay,
                                                      LocalDate beforeSevenDay,
                                                      LocalDate afterOneDay);
}
