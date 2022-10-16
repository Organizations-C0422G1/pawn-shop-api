package com.pawn_shop.service;

import com.pawn_shop.dto.projections.CustomerProjection;
import com.pawn_shop.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<CustomerProjection> findAllCustomer(String name, Pageable pageable);
    void deleteCustomer(Integer id);
}
