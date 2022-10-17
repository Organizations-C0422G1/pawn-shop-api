package com.pawn_shop.repository;

import com.pawn_shop.dto.projection.PawnItemDto;
import com.pawn_shop.model.pawn.PawnItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPawItemRepository extends JpaRepository<PawnItem, Long> {
    @Query(value = "select pi.`name`, pi.`status`, pt.`name` as pawnType, c.end_date as endDate, c.item_price as itemPrice " +
            " from pawn_item pi " +
            " join pawn_type pt on pi.pawn_type_id = pt.id " +
            " join contract c on pi.id = c.pawn_item_id " +
            " where pt.`name` like %:itemName% and pi.`name` like %:pawnName% ", nativeQuery = true,
            countQuery = "select count(*) from (select pi.`name`, pi.`status`, pt.`name` as pawnType, c.end_date as endDate, c.item_price as itemPrice " +
                    "            from pawn_item pi " +
                    "            join pawn_type pt on pi.pawn_type_id = pt.id " +
                    "            join contract c on pi.id = c.pawn_item_id " +
                    "            where pt.`name` like %:itemName% and pi.`name` like %:pawnName%) as pawnItem")
    Page<PawnItemDto> findAllPawnItem(Pageable pageable, @Param("itemName") String itemName, @Param("pawnName") String pawnName);

}
