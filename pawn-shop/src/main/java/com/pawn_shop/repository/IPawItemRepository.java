package com.pawn_shop.repository;

import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.model.pawn.PawnItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPawItemRepository extends JpaRepository<PawnItem, Long> {

    @Query(value = "SELECT" +
            "    pi.id as idPawnItem,pi.name as namePawnItem, pt.name AS namePawnType, c.item_price AS itemPrice" +
            " FROM" +
            "    pawn_item pi" +
            "        JOIN" +
            "    contract c ON c.pawn_item_id = pi.id" +
            "        JOIN" +
            "    pawn_type pt ON pt.id = pi.pawn_type_id" +
            " WHERE" +
            " pi.name LIKE %?1%" +
            " AND pi.pawn_type_id LIKE %?2%" +
            "        AND c.item_price LIKE %?3%" +
            "        AND c.status = 2",nativeQuery = true)

    <T> List<T> findAllPawnItem(String namePawnType, String idPawnItem,String price,Class<T> tClass);

    @Query(value = "select pi.id as idPawnItem,pi.name as namePawnItem, pt.name AS namePawnType, c.item_price AS itemPrice"+
            " FROM" +
            "    pawn_item pi" +
            "        JOIN" +
            "    contract c ON c.pawn_item_id = pi.id" +
            "        JOIN" +
            "    pawn_type pt ON pt.id = pi.pawn_type_id" +
            " WHERE" +
            " pi",nativeQuery = true)
    <T> List<T> findPawnItemById(Class<T> tClass);
}
