package com.pawn_shop.repository;

import com.pawn_shop.model.pawn.PawnType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPawnTypeRepository extends JpaRepository<PawnType,Long> {
}
