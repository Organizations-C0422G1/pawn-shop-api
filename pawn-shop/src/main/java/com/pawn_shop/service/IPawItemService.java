package com.pawn_shop.service;

import com.pawn_shop.dto.projection.PawnItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.pawn_shop.model.pawn.PawnItem;

import java.util.List;

public interface IPawItemService {
    Page<PawnItemDto> findAllPawnItem(Pageable pageable, String itemName, String pawnName);

    <T> List<T> findAllPawnItem(String namePawnType, String namePawnItem, String price, Class<T> tClass);

    PawnItem savePawnItem(PawnItem pawnItem);

    List<PawnItem> findAllPawnItem();

    PawnItem createQuickPawnItem(PawnItem pawnItem);
}

