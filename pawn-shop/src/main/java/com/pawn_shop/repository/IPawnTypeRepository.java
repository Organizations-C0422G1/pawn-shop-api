package com.pawn_shop.repository;

import com.pawn_shop.model.pawn.PawnType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPawnTypeRepository extends JpaRepository<PawnType, Long> {
    @Query(value = "select * from pawn_type", nativeQuery = true)
    List<PawnType> findAllPawnType();

    @Query(nativeQuery = true,value = "select pt.id, pt.name from pawn_type pt ")
    <T> List<T> findAllPawnTypeLiquidation(Class<T> tClass);
//
//    @Query(value = "select * from pawn_type",nativeQuery = true)
//    List<PawnType> findAllPawnType();

}

