package com.pawn_shop.controller;

import com.pawn_shop.dto.ContractLiquidationDto;
import com.pawn_shop.dto.ICustomerLiquidationDto;
import com.pawn_shop.dto.IPawnItemDtoList;
import com.pawn_shop.dto.IPawnTypeDtoList;
import com.pawn_shop.service.IContractService;
import com.pawn_shop.service.ICustomerService;
import com.pawn_shop.service.IPawItemService;
import com.pawn_shop.service.IPawnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class LiquidationRestController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IPawItemService iPawItemRepository;

    @Autowired
    private IPawnTypeService iPawnTypeService;

    @Autowired
    private IContractService iContractService;

    @GetMapping("/list/{name}")
    public ResponseEntity<List<ICustomerLiquidationDto>> findByNameCustomer(@RequestParam("name") Optional<String> name){
        String names = name.orElse("");
        List<ICustomerLiquidationDto> list = iCustomerService.findByNameCustomer(names, ICustomerLiquidationDto.class);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/pawnItem/list")
    public ResponseEntity<List<IPawnItemDtoList>> findByPawnItem(){
        List<IPawnItemDtoList> list = iPawItemRepository.findAllPawnItem(IPawnItemDtoList.class);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/pawnType/list")
    public ResponseEntity<List<IPawnTypeDtoList>> findByPawnType(
            @RequestParam("id") Optional<String> id,
            @RequestParam("name") Optional<String> name,
            @RequestParam("price") Optional<String> price){
        String ids = id.orElse("");
        String names = name.orElse("");
        String prices = price.orElse("");
        List<IPawnTypeDtoList> list = iPawnTypeService.findAllPawnTypeByNameAndPrice(names,ids,prices,IPawnTypeDtoList.class);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PatchMapping( "/liquidation")
    public ResponseEntity<Map<String,String>> updateLiquidation(@Valid @RequestBody ContractLiquidationDto contractDto, BindingResult bindingResult){
        try{
            if (bindingResult.hasErrors()) {
                Map<String, String> errMap = new HashMap<>();
                for (FieldError fieldError: bindingResult.getFieldErrors()){
                    errMap.put(fieldError.getField(),fieldError.getDefaultMessage());
                }
                return new ResponseEntity<>(errMap,HttpStatus.BAD_REQUEST);
            } else {
                this.iContractService.createLiquidation(contractDto.getLiquidationPrice(), contractDto.getReturnDate().toString()
                        , contractDto.getIdContract());
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
