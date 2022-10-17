package com.pawn_shop.service.impl;

import com.pawn_shop.dto.projection.IEmployeeDto;
import com.pawn_shop.model.employee.Employee;
import com.pawn_shop.repository.IEmployeeRepository;
import com.pawn_shop.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<IEmployeeDto> getAllEmployeeSearch( String searchKeyWordName, String searchKeyWordCode,Pageable pageable) {
        return iEmployeeRepository.getAllEmployeeSearch( searchKeyWordName, searchKeyWordCode , pageable);
    }


    @Override
    public void deleteEmployee(Long id) {
iEmployeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> findById(Long id) {
        return iEmployeeRepository.findByIds(id);
    }
}
