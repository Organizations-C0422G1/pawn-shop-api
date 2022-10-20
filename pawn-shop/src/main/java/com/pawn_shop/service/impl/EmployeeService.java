package com.pawn_shop.service.impl;

import com.pawn_shop.dto.IEmployeeDto;
import com.pawn_shop.repository.IEmployeeRepository;
import com.pawn_shop.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public IEmployeeDto findByUser(String user) {
        return this.iEmployeeRepository.findByUser(user);
    }
}
