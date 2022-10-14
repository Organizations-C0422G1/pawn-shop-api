package com.pawn_shop.controller;

import com.pawn_shop.model.pawn.PawnItem;
import com.pawn_shop.service.IPawItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RestPawnItemController {
    @Autowired
    private IPawItemService iPawItemService;
    @PostMapping("/addPawnItem")
    public ResponseEntity<PawnItem> addPawnItem(@RequestBody PawnItem pawnItem) {
        iPawItemService.savePawnItem(pawnItem);
        return new ResponseEntity<>(pawnItem,HttpStatus.OK);
    }
    @GetMapping ("/list/pawnItem")
    public ResponseEntity<List<PawnItem>> listPawnItem() {
        List<PawnItem> pawnItemList = iPawItemService.findAllPawnItem();
        if (pawnItemList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pawnItemList,HttpStatus.OK);
    }
}
