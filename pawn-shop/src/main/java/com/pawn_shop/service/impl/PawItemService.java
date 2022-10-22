package com.pawn_shop.service.impl;

import com.pawn_shop.dto.projection.PawnItemDto;
import com.pawn_shop.repository.IPawItemRepository;
import com.pawn_shop.service.IPawItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.pawn_shop.model.pawn.PawnItem;
import com.pawn_shop.repository.IPawItemRepository;
import com.pawn_shop.service.IPawItemService;
import java.util.List;

@Service
public class PawItemService implements IPawItemService {
    @Autowired
    private IPawItemRepository iPawItemRepository;
    @Override
    public Page<PawnItemDto> findAllPawnItem(Pageable pageable, String itemName, String pawnName) {
        return iPawItemRepository.findAllPawnItem(pageable, itemName, pawnName);
    }

    @Override
    public <T> List<T> findAllPawnItem(String namePawnType, String namePawnItem, String price, Class<T> tClass) {
        return iPawItemRepository.findAllPawnItem(namePawnType,namePawnItem, price, tClass);
    }

    public PawnItem savePawnItem(PawnItem pawnItem) {
        return iPawItemRepository.save(pawnItem);
    }

    @Override
    public List<PawnItem> findAllPawnItem() {
        return iPawItemRepository.findAll();
    }

    @Override
    public PawnItem createQuickPawnItem(PawnItem pawnItem) {
        pawnItem.setStatus(true);
        pawnItem.setName("");
        return this.iPawItemRepository.save(pawnItem);
    }

}
