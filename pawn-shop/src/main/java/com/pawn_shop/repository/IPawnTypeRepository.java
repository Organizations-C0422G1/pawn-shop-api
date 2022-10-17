package com.pawn_shop.repository;

import com.pawn_shop.model.pawn.PawnType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPawnTypeRepository extends JpaRepository<PawnType,Long> {

    @Query(nativeQuery = true,value = "select pt.id, pt.name from pawn_type pt ")
    <T> List<T> findAllPawnType(Class<T> tClass);

    @Query(nativeQuery = true,value = "select p.id, p.name, p.pawn_type_id as pawnTypeId, c.item_price as itemPrice from pawn_item p" +
            " join contract c on c.pawn_item_id = p.id" +
            " where p.name like %?1% and c.pawn_item_id like %?2% and c.item_price like %?3% and p.status =1")
    <T> List<T> findAllPawnTypeByNameAndPrice(String name, String id, String priceItem, Class<T> tClass);


}
