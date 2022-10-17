package com.pawn_shop.service;

import com.pawn_shop.dto.CustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<CustomerDto> findAllCustomer(String name, Pageable pageable);
    void deleteCustomer(Integer id);
}
