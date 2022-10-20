package com.pawn_shop.controller;

import com.pawn_shop.dto.EmployeeDto;
import com.pawn_shop.model.employee.Employee;
import com.pawn_shop.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findByIdEmployee(@PathVariable Long id){
        Employee employee= this.iEmployeeService.findById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<Void>updateById(@RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        this.iEmployeeService.update(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
