package com.pawn_shop.service;

import com.pawn_shop.model.customer.Customer;

import java.util.List;


public interface ICustomerService {

    List<Customer> findAllCustomer();

}
