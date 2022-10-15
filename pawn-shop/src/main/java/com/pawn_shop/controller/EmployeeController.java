package com.pawn_shop.controller;

import com.pawn_shop.model.login.LoginRequest;
import com.pawn_shop.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private IAppUserService appUserService;

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody LoginRequest loginRequest){
        this.appUserService.resetPassword(loginRequest.getUsername(), loginRequest.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
