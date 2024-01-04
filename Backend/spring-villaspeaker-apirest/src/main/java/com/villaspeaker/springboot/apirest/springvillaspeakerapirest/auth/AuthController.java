package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

import static org.apache.logging.log4j.ThreadContext.containsKey;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));

    }

    @PostMapping(value = "register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        Map<String, Object> response = authService.register(request);

        if (response != null && response.containsKey("error")){
            return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(response);
    }
}
