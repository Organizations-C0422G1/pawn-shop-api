package com.pawn_shop.controller;

import com.pawn_shop.jwt.JwtUtility;
import com.pawn_shop.model.login.AppUser;
import com.pawn_shop.model.login.LoginRequest;
import com.pawn_shop.model.login.LoginResponse;
import com.pawn_shop.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public")
@CrossOrigin("*")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private IAppUserService appUserService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetailService = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Long employeeId = this.appUserService.findByUsername(loginRequest.getUsername()).getEmployee().getId();

        List<String> roles = userDetailService.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        String jwt = jwtUtility.generateJwtToken(loginRequest.getUsername());
        return new ResponseEntity<>(new LoginResponse(jwt, roles, loginRequest.getUsername(), employeeId), HttpStatus.OK);
    }

    @GetMapping("/forgot-password/{email}")
    public ResponseEntity<?> getResetEmail(@PathVariable String email){
        AppUser user = this.appUserService.findByEmail(email);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String jwt = jwtUtility.generateJwtToken(user.getUsername());
        return new ResponseEntity<>(jwt,HttpStatus.OK);
    }

}
