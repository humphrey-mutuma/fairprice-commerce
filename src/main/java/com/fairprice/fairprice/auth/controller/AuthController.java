package com.fairprice.fairprice.auth.controller;

import com.fairprice.fairprice.auth.dto.LoginDto;
import com.fairprice.fairprice.auth.dto.LoginResponseDto;
import com.fairprice.fairprice.auth.dto.RegisterDto;
import com.fairprice.fairprice.auth.service.AuthService;
import com.fairprice.fairprice.reponse.ApiResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(@RequestBody RegisterDto registerDto) throws BadRequestException {
             String message = authService.register(registerDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(message, null));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDto>> login(@RequestBody LoginDto loginDto) {
             LoginResponseDto response = authService.login(loginDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ApiResponse<>("Successfully logged in", response));
    }
}
