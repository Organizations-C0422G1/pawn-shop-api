package com.pawn_shop.repository;

import com.pawn_shop.model.pawn.PawnItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPawItemRepository extends JpaRepository<PawnItem, Long> {

    @Query(nativeQuery = true,value = "select p.id, p.name, p.pawn_type_id from pawn_item p where p.status =1")
    <T> List<T> findAllPawnItem(Class<T> tClass);

//    @Query(nativeQuery = true,value = "select p.id, p.name, p.pawn_type_id from pawn_item p where p.status =1")
//    Paw
}
