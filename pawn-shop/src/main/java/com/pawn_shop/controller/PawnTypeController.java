package com.pawn_shop.controller;

import com.pawn_shop.model.pawn.PawnType;
import com.pawn_shop.service.IPawnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee/pawn-type")
public class PawnTypeController {
    @Autowired
    private IPawnTypeService iPawnTypeService;

    @GetMapping("")
    public ResponseEntity<List<PawnType>> displayPawnType() {
        List<PawnType> pawnTypeList = iPawnTypeService.findAllPawnType();
        if (pawnTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(pawnTypeList, HttpStatus.OK);
        }
    }
}