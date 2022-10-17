package com.pawn_shop.repository;

import com.pawn_shop.model.pawn.PawnImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPawnImgRepository extends JpaRepository<PawnImg, Long> {
}
