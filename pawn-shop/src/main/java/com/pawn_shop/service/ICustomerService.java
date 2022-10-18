package com.pawn_shop.service;

import com.pawn_shop.dto.ICustomerDto;
import com.pawn_shop.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<ICustomerDto> findAllCustomer(String name, Pageable pageable);

    void deleteCustomer(Integer id);

    void createCustomer(Customer newCustomer);

    void updateCustomer(Long id, Customer oldCustomer);

    List<Customer> findAll();
}
