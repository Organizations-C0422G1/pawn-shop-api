package com.pawn_shop.service;



import com.pawn_shop.model.pawn.PawnItem;

import java.util.List;

public interface IPawnItemService {
  List<PawnItem> findAllPawnItem();
}
