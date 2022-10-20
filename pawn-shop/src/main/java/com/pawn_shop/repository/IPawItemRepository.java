package com.pawn_shop.repository;

import com.pawn_shop.model.pawn.PawnItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IPawItemRepository extends JpaRepository<PawnItem, Long> {
    @Transactional
    @Modifying
    @Query(value = "update pawn_item set name = :name , pawn_type_id = :typeId where id = :id",nativeQuery = true)
    void updatePawnItem(@Param("name") String name, @Param("typeId") Long typeId, @Param("id") Long id);

    @Query(value = "select * from pawn_item",nativeQuery = true)
    List<PawnItem> pawnItemList();
}
