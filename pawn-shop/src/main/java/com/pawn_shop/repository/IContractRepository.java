package com.pawn_shop.repository;

import com.pawn_shop.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Long> {

    @Query(value = "select id,\n" +
            "   code,\n" +
            "   item_price,\n" +
            "   interest_rate,\n" +
            "   start_date,\n" +
            "   end_date,\n" +
            "   return_date,\n" +
            "   status,\n" +
            "   `type`,\n" +
            "   liquidation_price,\n" +
            "   customer_id,\n" +
            "   employee_id,\n" +
            "   pawn_item_id from contract where contract.status = 1", nativeQuery = true,
            countQuery = "select count(*) from contract where contract.status = 1")
    Page<Contract> findAllCompleteContract(Pageable pageable);


    @Query(value = "select id,\n" +
            "   code,\n" +
            "   item_price,\n" +
            "   interest_rate,\n" +
            "   start_date,\n" +
            "   end_date,\n" +
            "   return_date,\n" +
            "   status,\n" +
            "   `type`,\n" +
            "   liquidation_price,\n" +
            "   customer_id,\n" +
            "   employee_id,\n" +
            "   pawn_item_id from contract where (start_date between :startReturnDate  and :endReturnDate) and `status` = 1", nativeQuery = true,
            countQuery = "select count(*) from contract where (start_date between :startReturnDate  and :endReturnDate) and `status` = 1")
    Page<Contract> findCompleteContractByDate(@Param("startReturnDate") String startReturnDate,
                                              @Param("endReturnDate") String endReturnDate, Pageable pageable);

    @Query(value = "select id,\n" +
            "   code,\n" +
            "   item_price,\n" +
            "   interest_rate,\n" +
            "  start_date,\n" +
            "  end_date,\n" +
            "  return_date,\n" +
            "   status,\n" +
            "   `type`,\n" +
            "   liquidation_price,\n" +
            "   customer_id,\n" +
            "   employee_id,\n" +
            "   pawn_item_id from contract where `status` = 3", nativeQuery = true,
            countQuery = "select count(*) from contract where `status` = 3")
    Page<Contract> findAllLiquidatedContract(Pageable pageable);


    @Query(value = "select id,\n" +
            "   code,\n" +
            "   item_price,\n" +
            "   interest_rate,\n" +
            "  start_date,\n" +
            "  end_date,\n" +
            "  return_date,\n" +
            "   status,\n" +
            "   `type`,\n" +
            "   liquidation_price,\n" +
            "   customer_id,\n" +
            "   employee_id,\n" +
            "   pawn_item_id from contract where (start_date between :startReturnDate  and :endReturnDate) and `status` = 3", nativeQuery = true,
            countQuery = "select count(*) from contract where (start_date between :startReturnDate  and :endReturnDate) and `status` = 3")
    Page<Contract> findLiquidatedContractByDate(@Param("startReturnDate") String startReturnDate,
                                                @Param("endReturnDate") String endReturnDate, Pageable pageable);

    @Query(value = "select id,\n" +
            "   code,\n" +
            "   item_price,\n" +
            "   interest_rate,\n" +
            "  start_date,\n" +
            "  end_date,\n" +
            "  return_date,\n" +
            "   status,\n" +
            "   `type`,\n" +
            "   liquidation_price,\n" +
            "   customer_id,\n" +
            "   employee_id,\n" +
            "   pawn_item_id from contract where `status` = 0", nativeQuery = true,
            countQuery = "select count(*) from contract where `status` = 0")
    Page<Contract> findAllExpectedContract(Pageable pageable);


    @Query(value = "select id,\n" +
            "   code,\n" +
            "   item_price,\n" +
            "   interest_rate,\n" +
            "  start_date,\n" +
            "  end_date,\n" +
            "  return_date,\n" +
            "   status,\n" +
            "   `type`,\n" +
            "   liquidation_price,\n" +
            "   customer_id,\n" +
            "   employee_id,\n" +
            "   pawn_item_id from contract where (start_date between :startReturnDate  and :endReturnDate) and `status` = 0", nativeQuery = true,
            countQuery = "select count(*) from contract where (start_date between :startReturnDate  and :endReturnDate) and `status` = 0")
    Page<Contract> findExpectedContractByDate(@Param("startReturnDate") String startReturnDate,
                                              @Param("endReturnDate") String endReturnDate, Pageable pageable);


    @Query(value = "\n" +
            "\tSELECT \n" +
            "    contract.id,\n" +
            "    contract.code,\n" +
            "    contract.item_price AS itemPrice,\n" +
            "    contract.interest_rate AS interestRate,\n" +
            "    contract.start_date AS startDate,\n" +
            "    contract.end_date AS endDate,\n" +
            "    contract.return_date AS returnDate,\n" +
            "    contract.type,\n " +
            "    contract.status,\n" +
            "    contract.liquidation_price AS liquidationPrice,\n" +
            "    customer.name AS customer,\n" +
            "    employee.name AS employee,\n" +
            "    pawn_item.name AS pawnItem\n" +
            "FROM\n" +
            "    contract\n" +
            "        JOIN\n" +
            "    customer ON contract.customer_id = customer.id\n" +
            "        JOIN\n" +
            "    employee ON contract.employee_id = employee.id\n" +
            "        JOIN\n" +
            "    pawn_item ON contract.pawn_item_id = pawn_item.id\n" +
            "WHERE\n" +
            "    contract.status = 0 and (contract.start_date between :startReturnDate and :endReturnDate)", nativeQuery = true)
    <T> List<T> getAllExpectedContractByDate(@Param("startReturnDate") String startReturnDate,
                                             @Param("endReturnDate") String endReturnDate,
                                             Class<T> tClass);

    @Query(value = "SELECT \n" +
            "    contract.id,\n" +
            "    contract.code,\n" +
            "    contract.item_price AS itemPrice,\n" +
            "    contract.interest_rate AS interestRate,\n" +
            "    contract.start_date AS startDate,\n" +
            "    contract.end_date AS endDate,\n" +
            "    contract.return_date AS returnDate,\n" +
            "    contract.type,\n " +
            "    contract.status,\n" +
            "    contract.liquidation_price AS liquidationPrice,\n" +
            "    customer.name AS customer,\n" +
            "    employee.name AS employee,\n" +
            "    pawn_item.name AS pawnItem\n" +
            "FROM\n" +
            "    contract\n" +
            "        JOIN\n" +
            "    customer ON contract.customer_id = customer.id\n" +
            "        JOIN\n" +
            "    employee ON contract.employee_id = employee.id\n" +
            "        JOIN\n" +
            "    pawn_item ON contract.pawn_item_id = pawn_item.id\n" +
            "WHERE\n" +
            "    contract.status = 0", nativeQuery = true)
    <T> List<T> getAllExpectedContract(Class<T> tClass);

    @Query(value = "\n" +
            "\tSELECT \n" +
            "    contract.id,\n" +
            "    contract.code,\n" +
            "    contract.item_price AS itemPrice,\n" +
            "    contract.interest_rate AS interestRate,\n" +
            "    contract.start_date AS startDate,\n" +
            "    contract.end_date AS endDate,\n" +
            "    contract.return_date AS returnDate,\n" +
            "    contract.type,\n " +
            "    contract.status,\n" +
            "    contract.liquidation_price AS liquidationPrice,\n" +
            "    customer.name AS customer,\n" +
            "    employee.name AS employee,\n" +
            "    pawn_item.name AS pawnItem\n" +
            "FROM\n" +
            "    contract\n" +
            "        JOIN\n" +
            "    customer ON contract.customer_id = customer.id\n" +
            "        JOIN\n" +
            "    employee ON contract.employee_id = employee.id\n" +
            "        JOIN\n" +
            "    pawn_item ON contract.pawn_item_id = pawn_item.id\n" +
            "WHERE\n" +
            "    contract.status = 3 and (contract.start_date between :startReturnDate and :endReturnDate)", nativeQuery = true)
    <T> List<T> getAllLiquidationContractByDate(@Param("startReturnDate") String startReturnDate,
                                             @Param("endReturnDate") String endReturnDate,
                                             Class<T> tClass);

    @Query(value = "SELECT \n" +
            "    contract.id,\n" +
            "    contract.code,\n" +
            "    contract.item_price AS itemPrice,\n" +
            "    contract.interest_rate AS interestRate,\n" +
            "    contract.start_date AS startDate,\n" +
            "    contract.end_date AS endDate,\n" +
            "    contract.return_date AS returnDate,\n" +
            "    contract.type,\n " +
            "    contract.status,\n" +
            "    contract.liquidation_price AS liquidationPrice,\n" +
            "    customer.name AS customer,\n" +
            "    employee.name AS employee,\n" +
            "    pawn_item.name AS pawnItem\n" +
            "FROM\n" +
            "    contract\n" +
            "        JOIN\n" +
            "    customer ON contract.customer_id = customer.id\n" +
            "        JOIN\n" +
            "    employee ON contract.employee_id = employee.id\n" +
            "        JOIN\n" +
            "    pawn_item ON contract.pawn_item_id = pawn_item.id\n" +
            "WHERE\n" +
            "    contract.status = 3", nativeQuery = true)
    <T> List<T> getAllLiquidationContract(Class<T> tClass);

    @Query(value = "\n" +
            "\tSELECT \n" +
            "    contract.id,\n" +
            "    contract.code,\n" +
            "    contract.item_price AS itemPrice,\n" +
            "    contract.interest_rate AS interestRate,\n" +
            "    contract.start_date AS startDate,\n" +
            "    contract.end_date AS endDate,\n" +
            "    contract.return_date AS returnDate,\n" +
            "    contract.type,\n " +
            "    contract.status,\n" +
            "    contract.liquidation_price AS liquidationPrice,\n" +
            "    customer.name AS customer,\n" +
            "    employee.name AS employee,\n" +
            "    pawn_item.name AS pawnItem\n" +
            "FROM\n" +
            "    contract\n" +
            "        JOIN\n" +
            "    customer ON contract.customer_id = customer.id\n" +
            "        JOIN\n" +
            "    employee ON contract.employee_id = employee.id\n" +
            "        JOIN\n" +
            "    pawn_item ON contract.pawn_item_id = pawn_item.id\n" +
            "WHERE\n" +
            "    contract.status = 1 and (contract.start_date between :startReturnDate and :endReturnDate)", nativeQuery = true)
    <T> List<T> getAllCompleteContractByDate(@Param("startReturnDate") String startReturnDate,
                                                @Param("endReturnDate") String endReturnDate,
                                                Class<T> tClass);

    @Query(value = "SELECT \n" +
            "    contract.id,\n" +
            "    contract.code,\n" +
            "    contract.item_price AS itemPrice,\n" +
            "    contract.interest_rate AS interestRate,\n" +
            "    contract.start_date AS startDate,\n" +
            "    contract.end_date AS endDate,\n" +
            "    contract.return_date AS returnDate,\n" +
            "    contract.type,\n " +
            "    contract.status,\n" +
            "    contract.liquidation_price AS liquidationPrice,\n" +
            "    customer.name AS customer,\n" +
            "    employee.name AS employee,\n" +
            "    pawn_item.name AS pawnItem\n" +
            "FROM\n" +
            "    contract\n" +
            "        JOIN\n" +
            "    customer ON contract.customer_id = customer.id\n" +
            "        JOIN\n" +
            "    employee ON contract.employee_id = employee.id\n" +
            "        JOIN\n" +
            "    pawn_item ON contract.pawn_item_id = pawn_item.id\n" +
            "WHERE\n" +
            "    contract.status = 1", nativeQuery = true)
    <T> List<T> getAllCompleteContract(Class<T> tClass);
}
