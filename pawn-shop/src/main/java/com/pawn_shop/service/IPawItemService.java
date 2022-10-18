package com.pawn_shop.service;

import com.pawn_shop.dto.projection.PawnItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPawItemService {

    Page<PawnItemDto> findAllPawnItem(Pageable pageable, String itemName, String pawnName);

    <T> T detailContractPawnItem(Long id, Class<T> tClass);

}
