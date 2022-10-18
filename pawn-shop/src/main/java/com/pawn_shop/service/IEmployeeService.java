package com.pawn_shop.service;

import com.pawn_shop.dto.projection.IEmployeeDto;
import com.pawn_shop.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<IEmployeeDto> getAllEmployeeSearch(String searchKeyWordName, String searchKeyWordCode,Pageable pageable);

    void deleteEmployee(Long id);
   

    void update(Employee employee);

    Employee findById(Long id);
}
