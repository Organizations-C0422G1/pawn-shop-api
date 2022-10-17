package com.pawn_shop.controller;

import com.pawn_shop.jwt.JwtFilter;
import com.pawn_shop.jwt.JwtUtility;
import com.pawn_shop.model.login.AppRole;
import com.pawn_shop.model.login.LoginResponse;
import com.pawn_shop.service.IAppRoleService;
import com.pawn_shop.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private IAppRoleService appRoleService;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private JwtFilter jwtFilter;

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody Optional<String> newPassword, HttpServletRequest request) {
        if (!newPassword.isPresent()) {
            return new ResponseEntity<>("Không được để trống", HttpStatus.BAD_REQUEST);
        } else {
            if (String.valueOf(newPassword).length() > 30) {
                return new ResponseEntity<>("Mật khẩu không được quá 30 ký tự", HttpStatus.BAD_REQUEST);
            }
        }
        String jwt = jwtFilter.parseJwt(request);
        String username = jwtUtility.getUserNameFromJwtToken(jwt);

        this.appUserService.resetPassword(username, String.valueOf(newPassword));

        List<AppRole> roles = this.appRoleService.findByUsername(username);
        List<String> roleList = new ArrayList<>();
        for (AppRole role : roles) {
            roleList.add(role.getRole());
        }

        Long employeeId = this.appUserService.findByUsername(username).getEmployee().getId();

        return new ResponseEntity<>(new LoginResponse(jwt, roleList, username, employeeId), HttpStatus.OK);
    }
}
