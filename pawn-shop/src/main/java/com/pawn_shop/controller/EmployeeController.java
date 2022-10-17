package com.pawn_shop.controller;

import com.pawn_shop.dto.projections.IEmployeeDto;
import com.pawn_shop.model.employee.Employee;
import com.pawn_shop.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/list")
    public ResponseEntity<Page<IEmployeeDto>> getAllListEmployee(@PageableDefault(value = 5) Pageable pageable,
                                                                 @RequestParam Optional<String> name,
                                                                 @RequestParam Optional<String> employeeCode) {

        String searchKeyWordName = name.orElse("");
        String searchKeyWordCode = employeeCode.orElse("");
        Page<IEmployeeDto> employeeDtos = iEmployeeService.getAllEmployeeSearch(searchKeyWordName, searchKeyWordCode, pageable);
        if (employeeDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);


    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Employee>> findById(@PathVariable Long id) {
        List<Employee> employee = iEmployeeService.findById(id);
        if (!employee.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(employee, HttpStatus.OK);
    }
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Long id) {
        List<Employee> employeeList = iEmployeeService.findById(id);
        for (Employee employee : employeeList) {
            if (Objects.equals(id, employee.getId())) {
                iEmployeeService.deleteEmployee(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
            return new ResponseEntity(employeeList,HttpStatus.BAD_REQUEST);
    }
}
