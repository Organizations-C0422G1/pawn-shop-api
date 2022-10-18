package com.pawn_shop.service;

import com.pawn_shop.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    public Page<Customer> findAllCustomer (Pageable pageable);
    public Optional<Customer> findCustomerById (@Param("id") Long id);
    public Optional<Customer> findCustomerByIdCard(@Param("idCard") String idCard);
    List<Customer> findAllCustomer();
}
