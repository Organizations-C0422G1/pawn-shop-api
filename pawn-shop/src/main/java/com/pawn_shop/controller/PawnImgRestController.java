package com.pawn_shop.controller;

import com.pawn_shop.model.pawn.PawnImg;
import com.pawn_shop.service.IPawnImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class PawnImgRestController {
    @Autowired
    private IPawnImgService iPawnImgService;

    @PostMapping("/pawnImg/save")
    public ResponseEntity<Void> savePawnImg(@RequestBody PawnImg pawnImg) {
        iPawnImgService.savePawnImg(pawnImg);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
