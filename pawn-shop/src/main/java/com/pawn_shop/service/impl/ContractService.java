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

    public Page<Contract> findCompleteContractByDate(String startReturnDate, String endReturnDate, Pageable pageable) {
        if (startReturnDate.equals("") && endReturnDate.equals("")) {
            return iContractRepository.findAllCompleteContract(pageable);
        } else {
            return iContractRepository.findCompleteContractByDate(startReturnDate, endReturnDate, pageable);
        }
    }

    @Override
    public Contract findByIdInterest(Long id) {
        return this.iContractRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Contract> findLiquidationContractByDate(String startReturnDate, String endReturnDate, Pageable pageable) {
        if (startReturnDate.equals("") && endReturnDate.equals("")) {
            return iContractRepository.findAllLiquidatedContract(pageable);
        } else {
            return iContractRepository.findLiquidatedContractByDate(startReturnDate, endReturnDate, pageable);
        }
    }

    @Override
    public Page<Contract> findExpectedContractByDate(String startReturnDate, String endReturnDate, Pageable pageable) {
        if (startReturnDate.equals("") && endReturnDate.equals("")) {
            return iContractRepository.findAllExpectedContract(pageable);
        } else {
            return iContractRepository.findExpectedContractByDate(startReturnDate, endReturnDate, pageable);
        }
    }

    @Override
    public <T> List<T> getAllExpectedContractByDate(String startReturnDate, String endReturnDate, Class<T> tClass) {
        if (startReturnDate.equals("") && endReturnDate.equals("")) {
            return iContractRepository.getAllExpectedContract(tClass);
        } else {
            return iContractRepository.getAllExpectedContractByDate(startReturnDate, endReturnDate, tClass);
        }

    }

    @Override
    public <T> List<T> getAllLiquidationContractByDate(String startReturnDate, String endReturnDate, Class<T> tClass) {
        if (startReturnDate.equals("") && endReturnDate.equals("")) {
            return iContractRepository.getAllLiquidationContract(tClass);
        } else {
            return iContractRepository.getAllLiquidationContractByDate(startReturnDate, endReturnDate, tClass);
        }
    }

    @Override
    public <T> List<T> getAllCompleteContractByDate(String startReturnDate, String endReturnDate, Class<T> tClass) {
        if (startReturnDate.equals("") && endReturnDate.equals("")) {
            return iContractRepository.getAllCompleteContract(tClass);
        } else {
            return iContractRepository.getAllCompleteContractByDate(startReturnDate, endReturnDate, tClass);
        }
    }

    @Override
    public void updateStatusContract(Long idContract) {
        iContractRepository.updateStatusContract(idContract);
    }

    public void createLiquidation(Double price, String dateLiquidation, Long idContract) {
        iContractRepository.createLiquidation(price, dateLiquidation, idContract);
    }

    @Override
    public Long findContractByIdPawnItem(Long idPawnItem) {
        return iContractRepository.findContractByIdPawnItem(idPawnItem);
    }



    @Override
    public Page<ContractDto> contractPage(String customerName,
                                          String pawnItemName,
                                          String type,
                                          String startDate,
                                          String endDate,
                                          String status,
                                          Pageable pageable) {
        if (type.equals("")) {
            return iContractRepository.contractPage(
                    customerName,
                    pawnItemName,
                    1,
                    0,
                    startDate,
                    endDate,
                    status,
                    pageable);
        } else if (type.equals("1")) {
            return iContractRepository.contractPage(
                    customerName,
                    pawnItemName,
                    1,
                    1,
                    startDate,
                    endDate,
                    status,
                    pageable);
        }
        return iContractRepository.contractPage(
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
        return iContractRepository.findByIdContractDto(id);
    }

    @Override
    public void deleteContract(Long id) {
        iContractRepository.deleteContract(id);
    }

    @Override
    public Page<ContractDto> getAllContractPaginationAndSearch(Pageable pageable, String code, String customerName, String pawnItem, String startDate) {
        return this.iContractRepository.getAllContractPaginationAndSearch(pageable, code, customerName, pawnItem, startDate);
    }

    @Override
    public void returnItem(long id) {
        this.iContractRepository.returnItem(id);
    }

    //duyeen
    @Override
    public void saveContract(Contract contract) {
        Contract lastContract = this.iContractRepository.findContract();
        contract.setCode(contract.getCode()+(lastContract.getId()+1));
        iContractRepository.saveContract(contract.getCode(), contract.getEndDate(), contract.getInterestRate(), contract.getItemPrice(), contract.getLiquidationPrice(), contract.getReturnDate(), contract.getStartDate(), contract.getStatus(), contract.getCustomer().getId(), contract.getEmployee().getId(), contract.getPawnItem().getId(),contract.getType());
        Customer customer = customerService.findCustomerById(contract.getCustomer().getId()).orElse(null);
        mailService.sendMail(contract, customer.getEmail());
    }

    @Override
    public Contract findContract() {
        return iContractRepository.findContract();
    }

    //uyên
    @Override
    public List<Contract> findAllContract() {
        return iContractRepository.findAllContract();
    }

    @Override
    public List<Contract> top10Contract() {
        return iContractRepository.top10Contract();
    }

    @Override
    public void updateContract(Contract contract) {
        iContractRepository.updateContract(contract.getCode(),contract.getEndDate(),contract.getInterestRate(),
                contract.getItemPrice(),contract.getLiquidationPrice(),contract.getReturnDate(),contract.getStartDate(),
                contract.getType(),contract.getCustomer().getId(),contract.getEmployee().getId(),contract.getPawnItem().getId(), contract.getId());
    }


    @Override
    public Contract findIdContract(Long id) {
        return iContractRepository.findIdContract(id);
    }


    @Override
    public Contract createQuickContract(Contract contract) {
        return this.iContractRepository.save(contract);
    }

}

