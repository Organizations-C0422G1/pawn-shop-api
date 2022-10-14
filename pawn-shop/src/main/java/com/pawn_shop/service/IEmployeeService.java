package com.pawn_shop.service;

import com.pawn_shop.dto.projections.IEmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<IEmployeeDto> getAllEmployee(Pageable pageable, String searchKeyWordCode, String searchKeyWordName);
}
