package com.pawn_shop.service;

import com.pawn_shop.model.pawn.PawnItem;

import java.util.List;


public interface IPawItemService {
    PawnItem savePawnItem(PawnItem pawnItem);

    List<PawnItem> findAllPawnItem();

    PawnItem createQuickPawnItem(PawnItem pawnItem);
}
