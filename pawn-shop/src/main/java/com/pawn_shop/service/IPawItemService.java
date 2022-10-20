package com.pawn_shop.service;

import com.pawn_shop.model.pawn.PawnItem;

import java.util.List;

public interface IPawItemService {
    <T> List<T> findAllPawnItem(String namePawnType, String namePawnItem,String price,Class<T> tClass);
    PawnItem savePawnItem(PawnItem pawnItem);
    List<PawnItem> findAllPawnItem();
    PawnItem createQuickPawnItem(PawnItem pawnItem);

}

