package com.pawn_shop.service;

import com.pawn_shop.model.address.Address;
import com.pawn_shop.model.customer.Customer;

import java.time.LocalDate;

public interface ICustomerService {
    void createCustomer(Customer newCustomer);

}
