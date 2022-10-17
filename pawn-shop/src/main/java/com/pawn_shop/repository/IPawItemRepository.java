package com.pawn_shop.repository;

import com.pawn_shop.model.pawn.PawnItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPawItemRepository extends JpaRepository<PawnItem, Long> {
}
