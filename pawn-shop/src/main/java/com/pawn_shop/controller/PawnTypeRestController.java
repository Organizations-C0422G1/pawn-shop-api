package com.pawn_shop.controller;

import com.pawn_shop.model.pawn.PawnType;
import com.pawn_shop.service.IPawnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin (origins = "*")
public class PawnTypeRestController {
    @Autowired
    private IPawnTypeService iPawnTypeService;
    @GetMapping ("/contract/pawnType")
    public ResponseEntity<List<PawnType>> pawnTypeList () {
        List<PawnType> pawnTypeList = iPawnTypeService.findAllPawnType();
        if (pawnTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pawnTypeList,HttpStatus.OK);
    }
}
