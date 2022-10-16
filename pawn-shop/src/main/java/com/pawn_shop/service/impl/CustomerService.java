package com.pawn_shop.service.impl;

import com.pawn_shop.dto.projections.CustomerProjection;
import com.pawn_shop.model.customer.Customer;
import com.pawn_shop.repository.ICustomerRepository;
import com.pawn_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<CustomerProjection> findAllCustomer(String name, Pageable pageable) {
        return iCustomerRepository.findAllCustomer(name, pageable);
    }

    @Override
    public void deleteCustomer(Integer id) {
        iCustomerRepository.deleteCustomer(id);
    }
}
