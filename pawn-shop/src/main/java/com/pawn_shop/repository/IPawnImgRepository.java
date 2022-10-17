package com.pawn_shop.repository;

import com.pawn_shop.model.pawn.PawnImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPawnImgRepository extends JpaRepository<PawnImg, Long> {
    @Query(value = "insert into pawn_item_id(img_url,pawn_item_id) value(?1,?2)",nativeQuery = true)
    void create(String img_url, Integer pawn_item_id);

}
