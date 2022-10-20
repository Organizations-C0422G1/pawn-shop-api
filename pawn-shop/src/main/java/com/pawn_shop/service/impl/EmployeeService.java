package com.pawn_shop.service.impl;

import com.pawn_shop.model.employee.Employee;
import com.pawn_shop.repository.IEmployeeRepository;
import com.pawn_shop.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Employee findById(Long id) {
        return this.iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Employee employee) {
        String address = employee.getAddress();
        LocalDate dateOfBirth = employee.getDateOfBirth();
        String email = employee.getEmail();
        Boolean gender = employee.getGender();
        String img = employee.getImgUrl();
        String name = employee.getName();
        String phone = employee.getPhoneNumber();
        String idCard = employee.getIdCard();
        Long id = employee.getId();
        this.iEmployeeRepository.updateEmployee(address, dateOfBirth, email,
                gender, img, name, phone, idCard, id);
    }
}
