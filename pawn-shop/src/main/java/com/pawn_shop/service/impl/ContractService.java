package com.pawn_shop.service.impl;

import com.pawn_shop.email.MailService;
import com.pawn_shop.model.contract.Contract;
import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.repository.IContractRepository;
import com.pawn_shop.service.IContractService;
import com.pawn_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private MailService mailService;

    @Override
    public void saveContract(Contract contract) {
        iContractRepository.saveContract(contract.getCode(), contract.getEndDate(), contract.getInterestRate(), contract.getItemPrice(), contract.getLiquidationPrice(), contract.getReturnDate(), contract.getStartDate(), contract.getStatus(), contract.getCustomer().getId(), contract.getEmployee().getId(), contract.getPawnItem().getId(),contract.getType());
        Customer customer = customerService.findCustomerById(contract.getCustomer().getId()).orElse(null);
        mailService.sendMail(contract, customer.getEmail());
    }

    @Override
    public List<Contract> findAllContract() {
        return iContractRepository.findAll();
    }
}
