package com.pawn_shop.service.impl;

import com.pawn_shop.dto.projection.DetailContractPawnItemDto;
import com.pawn_shop.dto.projection.PawnItemDto;
import com.pawn_shop.repository.IPawItemRepository;
import com.pawn_shop.service.IPawItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public <T> T detailContractPawnItem(Long id,Class<T> tClass) {
        return iPawItemRepository.detailContractPawnItem(id, tClass);
    }

}
