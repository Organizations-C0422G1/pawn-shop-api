package com.pawn_shop.service.impl;

import com.pawn_shop.repository.IPawItemRepository;
import com.pawn_shop.service.IPawItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PawItemService implements IPawItemService {

<<<<<<< HEAD

=======
    @Autowired
    private IPawItemRepository iPawItemRepository;

    @Override
    public Page<PawnItemDto> findAllPawnItem(Pageable pageable, String itemName, String pawnName) {
        return iPawItemRepository.findAllPawnItem(pageable, itemName, pawnName);
    }
>>>>>>> bba05b2ddf91be359030c53a8e609456592c23a5
}
