package com.fairprice.fairprice.auth.service;

import com.fairprice.fairprice.auth.dto.LoginDto;
import com.fairprice.fairprice.auth.dto.LoginResponseDto;
import com.fairprice.fairprice.auth.dto.RegisterDto;
import com.fairprice.fairprice.auth.repo.AuthRepository;
 import com.fairprice.fairprice.user.model.User;
 import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    AuthenticationManager authManager;
    private final JWTService jwtService;
    private final AuthRepository authRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public String register(RegisterDto user) {
             // Create a new User entity and set the properties from RegisterDto
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(encoder.encode(user.getPassword()));
            // newUser.setRoles(user.getRoles()); // Assuming roles are set in RegisterDto

            // Save the new user to the database
            authRepository.save(newUser);
            return "Registration successful, please login!";
    }

   //    login user
   public LoginResponseDto login(LoginDto user) {
       try {
           // Attempt authentication
           Authentication authentication = authManager.authenticate(
                   new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
           );

           // Check if authentication was successful
           if (!authentication.isAuthenticated()) {
               throw new BadCredentialsException("Invalid Credentials, please check your username or password!");
           }

           // Generate a 24hrs new token
//           add as an env variable.
           long expirationTimeMillis = 24 * 60 * 60 * 1000; // 24 hours in milliseconds

           String token = jwtService.generateToken(user.getUsername(), expirationTimeMillis);

           // Retrieve user details from the database
           User userFromDb = authRepository.findByUsername(user.getUsername());

           // Return successful response with token and user details
           return new LoginResponseDto(token, userFromDb.getId(), user.getUsername(), userFromDb.getRoles());

       } catch (BadCredentialsException e) {
           // Return a response indicating invalid credentials
          throw  new BadCredentialsException( "Invalid credentials, please check your username or password!");
       }
   }

}
