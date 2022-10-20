package com.pawn_shop.service;

import com.pawn_shop.dto.IEmployeeDto;

public interface IEmployeeService {
    IEmployeeDto findByUser(String user);
}
