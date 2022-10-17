package com.pawn_shop.repository;

import com.pawn_shop.model.pawn.PawnItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface IPawItemRepository extends JpaRepository<PawnItem, Long> {

//    @Query(value = "INSERT INTO pawn_item (pawn_type_id,`status`) VALUES (?1 ,1)", nativeQuery = true)
//    void createQuickPawnItem(Long item);
}
