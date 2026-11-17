package com.example.jwt.model;

public class JwtResponse {
    private final String token;
    private final String tokenType;
    private final long expiresInSeconds;

    public JwtResponse(String token, String tokenType, long expiresInSeconds) {
        this.token = token;
        this.tokenType = tokenType;
        this.expiresInSeconds = expiresInSeconds;
    }

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public long getExpiresInSeconds() {
        return expiresInSeconds;
    }
}
