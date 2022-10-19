package com.pawn_shop.repository;

import com.pawn_shop.model.pawn.PawnImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IPawnImgRepository extends JpaRepository<PawnImg, Long> {
    @Transactional
    @Modifying
    @Query(value = "insert into pawn_img (img_url,pawn_item_id) values (?1,?2)",nativeQuery = true)
    void savePawnImg (String imgUrl, Long pawnItem);
}
