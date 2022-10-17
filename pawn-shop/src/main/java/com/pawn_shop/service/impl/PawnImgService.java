package com.pawn_shop.service.impl;

import com.pawn_shop.model.pawn.PawnImg;
import com.pawn_shop.repository.IPawnImgRepository;
import com.pawn_shop.service.IPawnImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PawnImgService implements IPawnImgService {
    @Autowired
    private IPawnImgRepository iPawnImgRepository;
    @Override
    public void savePawnImg(PawnImg pawnImg) {
        iPawnImgRepository.savePawnImg(pawnImg.getImgUrl(),pawnImg.getPawnItem().getId());
    }
}
