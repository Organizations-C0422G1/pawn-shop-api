package com.pawn_shop.controller;
import com.pawn_shop.dto.projections.IEmployeeDto;
import com.pawn_shop.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/employee")
    public ResponseEntity<Page<IEmployeeDto>> getAllListEmployee(@PageableDefault(value = 6) Pageable pageable,
                                                                 @RequestParam Optional<String> name,
                                                                 @RequestParam Optional<String> employeeCode) {

        String searchKeyWordName = name.orElse("");
        String searchKeyWordCode = employeeCode.orElse("");
        Page<IEmployeeDto> employeeDtos = iEmployeeService.getAllEmployee(pageable, searchKeyWordCode, searchKeyWordName);
            if (employeeDtos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employeeDtos, HttpStatus.OK);


    }
}
