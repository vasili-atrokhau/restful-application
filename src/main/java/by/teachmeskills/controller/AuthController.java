package by.teachmeskills.controller;

import by.teachmeskills.exception.EmployeeException;
import by.teachmeskills.payload.AuthRequest;
import by.teachmeskills.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CustomUserDetailsService userDetailsService;

    @PostMapping
    public UserDetails login(@RequestBody AuthRequest authRequest) throws EmployeeException {
        return userDetailsService.loadUserByUsername(authRequest.getUsername());
    }
}