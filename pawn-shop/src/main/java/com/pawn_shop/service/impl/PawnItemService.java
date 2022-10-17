package com.pawn_shop.service.impl;

import com.pawn_shop.model.pawn.PawnItem;
import com.pawn_shop.repository.IPawItemRepository;
import com.pawn_shop.service.IPawnItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PawnItemService implements IPawnItemService {
    @Autowired
    private IPawItemRepository iPawnItemRepository;

    @Override
    public List<PawnItem> findAllPawnItem() {
        return iPawnItemRepository.findAllItem();
    }
}
