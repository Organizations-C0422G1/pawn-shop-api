package com.pawn_shop.repository;

import com.pawn_shop.model.pawn.PawnType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPawnTypeRepository extends JpaRepository<PawnType,Long> {
    @Query(value = "select pawn_type.id, pawn_type.name from pawn_type",nativeQuery = true)
    List<PawnType> findAllPawnType();
}