package com.pawn_shop.service.impl;

import com.pawn_shop.model.pawn.PawnItem;
import com.pawn_shop.repository.IPawItemRepository;
import com.pawn_shop.service.IPawItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PawItemService implements IPawItemService {

    @Autowired
    private IPawItemRepository iPawnItemRepository;

    @Override
    public void create(PawnItem pawnItem) {
        iPawnItemRepository.save(pawnItem);
    }
}
