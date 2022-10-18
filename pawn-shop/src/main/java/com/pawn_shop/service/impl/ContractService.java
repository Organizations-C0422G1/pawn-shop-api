package com.pawn_shop.service.impl;

import com.pawn_shop.dto.projection.ContractDto;
import com.pawn_shop.email.MailService;
import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.repository.IContractRepository;
import com.pawn_shop.service.IContractService;
import com.pawn_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private MailService mailService;

    @Override
    public Page<ContractDto> contractPage(String customerName,
                                          String pawnItemName,
                                          String type,
                                          String startDate,
                                          String endDate,
                                          String status,
                                          Pageable pageable) {
        if (type.equals("")) {
            return contractRepository.contractPage(
                    customerName,
                    pawnItemName,
                    1,
                    0,
                    startDate,
                    endDate,
                    status,
                    pageable);
        } else if (type.equals("1")) {
            return contractRepository.contractPage(
                    customerName,
                    pawnItemName,
                    1,
                    1,
                    startDate,
                    endDate,
                    status,
                    pageable);
        }
        return contractRepository.contractPage(
                customerName,
                pawnItemName,
                0,
                0,
                startDate,
                endDate,
                status,
                pageable);
    }

    @Override
    public ContractDto findById(Long id) {
        return contractRepository.findByIdContractDto(id);
    }

    @Override
    public void deleteContract(Long id) {
        contractRepository.deleteContract(id);
    }

    @Override
    public Page<ContractDto> getAllContractPaginationAndSearch(Pageable pageable, String code, String customerName, String pawnItem, String startDate) {
        return this.contractRepository.getAllContractPaginationAndSearch(pageable, code, customerName, pawnItem, startDate);
    }

    @Override
    public void returnItem(long id) {
        this.contractRepository.returnItem(id);
    }

    @Override
    public void saveContract(Contract contract) {
        contractRepository.saveContract(contract.getCode(), contract.getEndDate(), contract.getInterestRate(), contract.getItemPrice(), contract.getLiquidationPrice(), contract.getReturnDate(), contract.getStartDate(), contract.getStatus(), contract.getCustomer().getId(), contract.getEmployee().getId(), contract.getPawnItem().getId(),contract.getType());
        Customer customer = customerService.findCustomerById(contract.getCustomer().getId()).orElse(null);
        mailService.sendMail(contract, customer.getEmail());
    }

}

