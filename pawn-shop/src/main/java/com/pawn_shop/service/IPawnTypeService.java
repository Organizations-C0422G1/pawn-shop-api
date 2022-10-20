package com.pawn_shop.service;

import com.pawn_shop.model.pawn.PawnImg;
import com.pawn_shop.model.pawn.PawnType;

import java.util.List;

public interface IPawnTypeService {
    List<PawnType> findAllPawnType();

    void updatePawnType(PawnType pawnType);
}
