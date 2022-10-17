package com.pawn_shop.service.impl;

import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.repository.ICustomerRepository;
import com.pawn_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public void createCustomer(Customer newCustomer) {
        iCustomerRepository.createCustomer( newCustomer.getDateOfBirth(), newCustomer.getEmail(),
                newCustomer.getGender(), newCustomer.getIdCard(), newCustomer.getImgUrl(), newCustomer.getName(),
                newCustomer.getPhoneNumber(), newCustomer.getStatus(), newCustomer.getAddress());
    }

    @Override
    public void updateCustomer(Long id, Customer oldCustomer) {
        iCustomerRepository.updateCustomer( oldCustomer.getDateOfBirth(), oldCustomer.getEmail(),
                oldCustomer.getGender(), oldCustomer.getIdCard(), oldCustomer.getImgUrl(), oldCustomer.getName(),
                oldCustomer.getPhoneNumber(), oldCustomer.getStatus(), oldCustomer.getAddress().getId(),oldCustomer.getId());
    }

//    @Override
//    public void updateCustomer(Customer oldCustomer) {
//        iCustomerRepository.updateCustomer(oldCustomer.getId(), oldCustomer.getDateOfBirth(), oldCustomer.getEmail(),
//                oldCustomer.getGender(), oldCustomer.getIdCard(), oldCustomer.getImgUrl(), oldCustomer.getName(),
//                oldCustomer.getPhoneNumber(), oldCustomer.getStatus(), oldCustomer.getAddress(), oldCustomer.getCode());
//    }
}
