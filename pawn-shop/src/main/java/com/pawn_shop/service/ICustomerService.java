package com.pawn_shop.service;

import com.pawn_shop.model.customer.Customer;

import java.util.Optional;

public interface ICustomerService {
    Optional<Customer> findById(int id);

}
