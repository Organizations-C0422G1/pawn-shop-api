package com.pawn_shop.controller;

import com.pawn_shop.dto.ContractDto;
import com.pawn_shop.model.address.Address;
import com.pawn_shop.model.address.District;
import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.model.pawn.PawnItem;
import com.pawn_shop.model.pawn.PawnType;
import com.pawn_shop.service.IAddressService;
import com.pawn_shop.service.IContractService;
import com.pawn_shop.service.ICustomerService;
import com.pawn_shop.service.IPawItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/contracts")
public class ContractRestController {
    @Autowired
    private IPawItemService iPawItemService;

    @Autowired
    private IAddressService iAddressService;

    @Autowired
    private IContractService iContractService;

    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping(value = "/createQuickContract")
    public ResponseEntity<?> createQuickContract(@RequestBody @Valid ContractDto contractDto,
                                                 BindingResult bindingResult) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errMap = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(errMap, HttpStatus.BAD_REQUEST);
        }
        PawnItem tempPawnItem = new PawnItem();
        Address tempAddress = new Address();
        Customer tempCustomer = new Customer();
        Contract tempContract = new Contract();

        PawnType tempPawnType = new PawnType();
        tempPawnType.setId(contractDto.getPawnItemDto().getPawnTypeDto().getId());
        tempPawnItem.setPawnType(tempPawnType);
        PawnItem pawnItem = this.iPawItemService.createQuickPawnItem(tempPawnItem);

        District tempDistrict = new District();
        tempDistrict.setId(contractDto.getCustomerDto().getAddressDto().getDistrictDto().getId());
        tempAddress.setDistrict(tempDistrict);
        Address address = this.iAddressService.createQuickAddress(tempAddress);

        tempCustomer.setAddress(address);
        tempCustomer.setName(contractDto.getCustomerDto().getName());
        tempCustomer.setPhoneNumber(contractDto.getCustomerDto().getPhoneNumber());
        tempCustomer.setStatus(true);
        Customer customer = this.iCustomerService.createQuickCustomer(tempCustomer);

        tempContract.setCustomer(customer);
        tempContract.setPawnItem(pawnItem);
        tempContract.setStatus(4);
        Contract contract = this.iContractService.createQuickContract(tempContract);
        return new ResponseEntity<>(contract, HttpStatus.CREATED);
    }
}
