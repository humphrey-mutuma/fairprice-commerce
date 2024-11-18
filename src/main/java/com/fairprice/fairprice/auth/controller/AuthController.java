package com.fairprice.fairprice.auth.controller;

import com.fairprice.fairprice.auth.dto.AuthDto;
import com.fairprice.fairprice.auth.dto.AuthResponseDto;
import com.fairprice.fairprice.auth.service.AuthService;
import com.fairprice.fairprice.reponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"http://localhost:3000", "https://fairpriceshop.vercel.app"})
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/auth")
    public ResponseEntity<ApiResponse<AuthResponseDto>> authenticate(@RequestBody AuthDto authDto) {
             AuthResponseDto response = authService.authenticate(authDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ApiResponse<>("Successfully logged in", response));
    }
}
