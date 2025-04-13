package com.ssharaev.webauthnexample.web;

import com.ssharaev.webauthnexample.service.AuthService;
import com.ssharaev.webauthnexample.web.dto.AuthenticationRequest;
import com.ssharaev.webauthnexample.web.dto.AuthenticationResponse;
import com.ssharaev.webauthnexample.web.dto.UserInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@Tag(name = "Auth controller")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-in")
    @Operation(summary = "Login")
    public AuthenticationResponse signIn(@RequestBody AuthenticationRequest authenticationRequest,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
        return new AuthenticationResponse(authService.signIn(
                        authenticationRequest.username(), authenticationRequest.password(), request, response)
        );
    }

    @SecurityRequirements
    @PostMapping("/register")
    @Operation(summary = "Register")
    public void register(@RequestBody AuthenticationRequest authenticationRequest) {
        authService.register(authenticationRequest.username(), authenticationRequest.password());
    }

    @GetMapping("/user/info")
    @Operation(summary = "UserEntity info")
    public UserInfoResponse userInfo() {
        return new UserInfoResponse(authService.getUserInfo());
    }


    @PostMapping("/logout")
    @Operation(summary = "Logout")
    public void logout() {
        // This endpoint is only for clearing cookies
    }
}