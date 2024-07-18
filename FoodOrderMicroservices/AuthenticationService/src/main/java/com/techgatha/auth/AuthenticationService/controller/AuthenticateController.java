package com.techgatha.auth.AuthenticationService.controller;

import com.techgatha.auth.AuthenticationService.dto.AuthenticationRequest;
import com.techgatha.auth.AuthenticationService.entity.UserInfo;
import com.techgatha.auth.AuthenticationService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticateController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;


    /**
     * {
     *     "name":"prashant",
     *     "password":"456",
     *     "email":"prashant@gmail.com"
     * }
     * {
     *     "name":"shalini",
     *     "password":"123",
     *     "email":"shalini@gmail.com"
     * }
     * @param userInfo
     * @return
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody UserInfo userInfo){
        return authService.saveUser(userInfo);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthenticationRequest authRequest) {
        System.out.println("get token "+authRequest.getUsername()+" "+authRequest.getPassword());
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
      //  Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        System.out.println(authenticate);
        if (authenticate.isAuthenticated()) {
            System.out.println("not true");
            return authService.generateToken(authRequest.getUsername());
        } else {
            System.out.println("true");
            throw new RuntimeException("invalid access");
        }

    }
    @GetMapping("/user/{id}")
    public UserInfo fetchUserById(@PathVariable  int id){
        return authService.getUserInfo(id);
    }


}
