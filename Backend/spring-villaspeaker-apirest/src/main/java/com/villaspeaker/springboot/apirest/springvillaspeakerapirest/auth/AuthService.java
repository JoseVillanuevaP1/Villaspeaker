package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.auth;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dao.ClienteDao;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Cliente;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Role;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.User;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.jwt.JwtService;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserDao userDao;
    private final ClienteDao clienteDao;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userDao.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public Map<String, Object> register(RegisterRequest request) {

        Map<String, Object> response = new HashMap<>();

        if (userDao.findByUsername(request.getUsername()).isPresent()){
            response.put("error", "Error, El email ya existe en la base de datos.");
            return response;
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .role(Role.USER)
                .build();
        userDao.save(user);

        Cliente cliente = new Cliente();

        cliente.setNombres(request.getFirstname());
        cliente.setApellidos(request.getLastname());
        cliente.setDni(request.getDni());
        cliente.setDireccion(request.getDireccion());
        cliente.setPassword(request.getPassword());
        cliente.setEmail(request.getUsername());
        cliente.setUser(user);

        clienteDao.save(cliente);

        response.put("token",jwtService.getToken(user));
        return response;
    }
}
