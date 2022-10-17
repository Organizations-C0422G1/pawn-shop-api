package com.pawn_shop.controller;

import com.pawn_shop.dto.projection.PawnItemDto;
import com.pawn_shop.service.IPawItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/employee/pawnItemRest")
public class PawnItemController {
    @Autowired
    private IPawItemService iPawItemService;

    @GetMapping(value = "")
    public ResponseEntity<Page<PawnItemDto>> displayPawnItem(@PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> itemName, @RequestParam Optional<String> pawnName) {

        String keywordItemName = itemName.orElse("");
        String keywordPawnName = pawnName.orElse("");

        Page<PawnItemDto> pawnItemList = iPawItemService.findAllPawnItem(pageable, keywordItemName, keywordPawnName);
        if (pawnItemList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(pawnItemList, HttpStatus.OK);
        }
    }

}
