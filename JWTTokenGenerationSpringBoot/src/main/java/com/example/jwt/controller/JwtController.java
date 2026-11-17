package com.example.jwt.controller;

import com.example.jwt.model.JwtRequest;
import com.example.jwt.model.JwtResponse;
import com.example.jwt.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jwt")
public class JwtController {

    private final JwtService jwtService;

    public JwtController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/generate")
    public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest request) {
        if (request == null || request.getPayload() == null || request.getPayload().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        String token = jwtService.generateToken(request.getPayload());
        JwtResponse response = new JwtResponse(
                token, "Bearer", jwtService.getExpirationSeconds());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
