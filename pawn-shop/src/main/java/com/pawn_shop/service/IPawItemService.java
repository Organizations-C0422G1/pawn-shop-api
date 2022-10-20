package com.pawn_shop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPawItemService {
<<<<<<< HEAD


=======
    Page<PawnItemDto> findAllPawnItem(Pageable pageable, String itemName, String pawnName);
>>>>>>> bba05b2ddf91be359030c53a8e609456592c23a5
}
