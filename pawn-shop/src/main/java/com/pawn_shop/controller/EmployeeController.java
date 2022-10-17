package com.pawn_shop.controller;

import com.pawn_shop.model.login.AppRole;
import com.pawn_shop.model.login.LoginRequest;
import com.pawn_shop.model.login.LoginResponse;
import com.pawn_shop.service.IAppRoleService;
import com.pawn_shop.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private IAppRoleService appRoleService;

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody @Valid LoginRequest loginRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        this.appUserService.resetPassword(loginRequest.getUsername(), loginRequest.getPassword());

        List<AppRole> roles = this.appRoleService.findByUsername(loginRequest.getUsername());
        List<String> roleList = new ArrayList<>();
        for (AppRole role : roles) {
            roleList.add(role.getRole());
        }

        Long employeeId = this.appUserService.findByUsername(loginRequest.getUsername()).getEmployee().getId();

        return new ResponseEntity<>(new LoginResponse("", roleList, loginRequest.getUsername(), employeeId), HttpStatus.OK);
    }
}
