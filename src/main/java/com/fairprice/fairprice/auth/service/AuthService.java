package com.fairprice.fairprice.auth.service;

import com.fairprice.fairprice.auth.dto.AuthDto;
import com.fairprice.fairprice.auth.dto.AuthResponseDto;
import com.fairprice.fairprice.auth.repo.AuthRepository;
import com.fairprice.fairprice.exceptions.ResourceNotFoundException;
import com.fairprice.fairprice.user.model.User;
 import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    AuthenticationManager authManager;
    private final JWTService jwtService;
    private final AuthRepository authRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    @Transactional
    public AuthResponseDto authenticate(AuthDto authDto) {
        // Create a new User entity and set the properties from RegisterDto
        User user =  authRepository.findByUsername(authDto.getUsername())
                    .orElseGet(() ->  register(authDto.getUsername(), authDto.getPassword()));

        return login(user , authDto.getPassword());

     }

    public User register(String username, String password) {
        // Create a new User entity and set the properties from RegisterDto
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(encoder.encode(password));
        // newUser.setRoles(user.getRoles()); // Assuming roles are set in RegisterDto

        return authRepository.save(newUser);
    }

    //    login user
   public AuthResponseDto login(User user, String password ) {

       try {

           // Attempt authentication
           Authentication authentication = authManager.authenticate(
                   new UsernamePasswordAuthenticationToken(user.getUsername(), password)
           );

           // Check if authentication was successful
           if (!authentication.isAuthenticated()) {
               throw new BadCredentialsException("Invalid Credentials, please check your username or password!");
           }

           // Generate a 24hrs new token
//           add as an env variable.
           long expirationTimeMillis = 24 * 60 * 60 * 1000; // 24 hours in milliseconds

           String token = jwtService.generateToken(user.getUsername(), expirationTimeMillis);

           // Return successful response with token and user details
           return new AuthResponseDto(token, user.getId(), user.getUsername(),user.getPoints(), user.getRoles());

       } catch (BadCredentialsException e) {
           // Return a response indicating invalid credentials
          throw  new BadCredentialsException( "Invalid credentials, please check your username or password!");
       }
   }

}
