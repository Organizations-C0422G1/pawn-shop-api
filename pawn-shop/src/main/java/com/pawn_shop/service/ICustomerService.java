package com.pawn_shop.service;

import com.pawn_shop.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> findAll();

    public <T> List<T> kiemAll(Class<T> tClass);
    public <T> List<T> findByNameCustomer(String name,Class<T> tClass);


}
