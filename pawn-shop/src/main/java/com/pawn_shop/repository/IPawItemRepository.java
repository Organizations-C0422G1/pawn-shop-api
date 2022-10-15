package com.pawn_shop.repository;

import com.pawn_shop.model.pawn.PawnItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPawItemRepository extends JpaRepository<PawnItem, Long> {
}
