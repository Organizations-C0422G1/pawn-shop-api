package com.pawn_shop.service.impl;

import com.pawn_shop.dto.projections.IEmployeeDto;
import com.pawn_shop.repository.IEmployeeRepository;
import com.pawn_shop.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<IEmployeeDto> getAllEmployee(Pageable pageable, String searchKeyWordCode, String searchKeyWordName) {
        return iEmployeeRepository.getAllEmployee(pageable,searchKeyWordCode,searchKeyWordName);
    }
}
