package com.pawn_shop.service;

import com.pawn_shop.dto.ICustomerDto;
import com.pawn_shop.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Page<ICustomerDto> findAllCustomer(String name, Pageable pageable);

    void deleteCustomer(Integer id);

    void createCustomer(Customer newCustomer);

    void updateCustomer(Long id, Customer oldCustomer);

    List<Customer> findAll();

    Page<Customer> findAllCustomer(Pageable pageable);

    Optional<Customer> findCustomerById(@Param("id") Long id);

    Optional<Customer> findCustomerByIdCard(@Param("idCard") String idCard);

    List<Customer> findAllCustomer();

    Customer createQuickCustomer(Customer customer);
}
