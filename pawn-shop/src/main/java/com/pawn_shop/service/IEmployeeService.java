package com.pawn_shop.service;

import com.pawn_shop.model.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;

public interface IEmployeeService {

    Employee findById(Long id);

    void update(Employee employee);
}
