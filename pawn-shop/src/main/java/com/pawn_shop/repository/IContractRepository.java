package com.pawn_shop.repository;

import com.pawn_shop.dto.projection.ContractDto;

import com.pawn_shop.dto.projection.MailAutoProjection;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


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

    @Query(value = "select ct.code, c.name as customer, pi.name as pawnItem, " +
            " ct.item_price as itemPrice, ct.start_date as startDate, " +
            " ct.end_date as endDate, ct.interest_rate as interestRate, " +
            " ct.return_date as returnDate, ct.liquidation_price as liquidationPrice " +
            " from contract ct " +
            " join customer c on ct.customer_id = c.id " +
            " join pawn_item pi on ct.pawn_item_id = pi.id " +
            " where (ct.code like %:code% and c.name like %:customerName% " +
            " and pi.name like %:pawnItem% and ct.start_date >= :startDate) " +
            " and ct.status = 0", nativeQuery = true,
            countQuery = "select count(*) from (" +
                    " select ct.code, c.name as customer, pi.name as pawnItem, " +
                    " ct.item_price as itemPrice, ct.start_date as startDate, " +
                    " ct.end_date as endDate, ct.interest_rate as interestRate, " +
                    " ct.return_date as returnDate, ct.liquidation_price as liquidationPrice " +
                    " from contract ct " +
                    " join customer c on ct.customer_id = c.id " +
                    " join pawn_item pi on ct.pawn_item_id = pi.id " +
                    " where (ct.code like %:code% and c.name like %:customerName% " +
                    " and pi.name like %:pawnItem% and ct.start_date >= :startDate) " +
                    " and ct.status = 0) contracts")
    Page<ContractDto> getAllContractPaginationAndSearch(Pageable pageable, @Param("code") String code, @Param("customerName") String customerName,
                                                        @Param("pawnItem") String pawnItem, @Param("startDate") String startDate);

    @Modifying
    @Query(value = "update contract set status = 1 where id = :id", nativeQuery = true)
    void returnItem(@Param("id") long id);

    // duyên
    @Modifying
    @Transactional
    @Query(value = "insert into contract (code,end_date,interest_rate,item_price,liquidation_price,return_date,start_date,status,customer_id,employee_id," +
            "pawn_item_id,`type`) value (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12)", nativeQuery = true)
    void saveContract(String code, LocalDate endDate, Double interestRate, Double itemPrice, Double liquidationPrice, LocalDate returnDate, LocalDate startDate, int status, Long customerId, Long employeeId, Long pawnItemId, boolean type);

    @Query(value = "select * from contract order by contract.id desc limit 1",nativeQuery = true)
    Contract findContract();

    //uyên
    @Modifying
    @Query(value = "update contract set code = :code , end_date = :endDate, interest_rate = :interestRate, item_price = :itemPrice," +
            "liquidation_price = :liquidationPrice, return_date = :returnDate,start_date = :startDate, type = :type," +
            "customer_id = :customerId, employee_id = :employeeId, pawn_item_id = :pawnItemId where id = :id ", nativeQuery = true)
    void updateContract(@Param("code") String code, @Param("endDate")LocalDate endDate,@Param("interestRate") Double interestDate,
                        @Param("itemPrice") Double itemPrice, @Param("liquidationPrice") Double liquidationPrice,@Param("returnDate") LocalDate returnDate ,
                        @Param("startDate") LocalDate startDate, @Param("type") Boolean type,
                        @Param("customerId") Long customerId, @Param("employeeId") Long employeeId,
                        @Param("pawnItemId") Long pawnItemId, @Param("id") Long id);

    @Query(value = "select * from contract where start_date = current_date order by id desc limit 10 ", nativeQuery = true)
    List<Contract> top10Contract();

    @Query(value = "select  * from contract where status_delete = 0", nativeQuery = true)
    List<Contract> findAllContract();


    @Query(value = "select * from contract where id = :id",nativeQuery = true)
    Contract findIdContract(@Param("id") Long id);

}

