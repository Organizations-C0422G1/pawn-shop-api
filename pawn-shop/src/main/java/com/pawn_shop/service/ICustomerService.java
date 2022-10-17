package com.pawn_shop.service;


import com.pawn_shop.model.customer.Customer;


public interface ICustomerService {
    void createCustomer(Customer newCustomer);

    void updateCustomer(Long id,Customer oldCustomer);

}
