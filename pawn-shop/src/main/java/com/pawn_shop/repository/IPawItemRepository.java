package com.pawn_shop.repository;

import com.pawn_shop.dto.projection.PawnItemDto;
import com.pawn_shop.model.pawn.PawnItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPawItemRepository extends JpaRepository<PawnItem, Long> {

    @Query(value = "SELECT \n" +
            "    cus.`name` AS nameCustomer,\n" +
            "    pi.`name` AS namePawnItem,\n" +
            "    pt.`name` AS namePawnType,\n" +
            "    c.`status`,\n" +
            "    c.id AS idContract,\n" +
            "    c.item_price AS itemPrice,\n" +
            "    c.start_date AS startDate,\n" +
            "    c.end_date AS endDate\n" +
            "FROM\n" +
            "    contract c\n" +
            "        JOIN\n" +
            "    customer cus ON c.customer_id = cus.id\n" +
            "        JOIN\n" +
            "    pawn_item pi ON c.pawn_item_id = pi.id\n" +
            "        JOIN\n" +
            "    pawn_type pt ON pi.pawn_type_id = pt.id" +
            " where pt.`name` like %:itemName% and pi.`name` like %:pawnName% and c.`status`= '0'", nativeQuery = true,
            countQuery = "select count(*) from (SELECT \n" +
                    "    cus.`name` AS nameCustomer,\n" +
                    "    pi.`name` AS namePawnItem,\n" +
                    "    pt.`name` AS namePawnType,\n" +
                    "    c.`status`,\n" +
                    "    c.id AS idContract,\n" +
                    "    c.item_price AS itemPrice,\n" +
                    "    c.start_date AS startDate,\n" +
                    "    c.end_date AS endDate\n" +
                    "FROM\n" +
                    "    contract c\n" +
                    "        JOIN\n" +
                    "    customer cus ON c.customer_id = cus.id\n" +
                    "        JOIN\n" +
                    "    pawn_item pi ON c.pawn_item_id = pi.id\n" +
                    "        JOIN\n" +
                    "    pawn_type pt ON pi.pawn_type_id = pt.id" +
                    " where pt.`name` like %:itemName% and pi.`name` like %:pawnName% and c.`status`= '0')  as pawnItem")
    Page<PawnItemDto> findAllPawnItem(Pageable pageable, @Param("itemName") String itemName, @Param("pawnName") String pawnName);

}
