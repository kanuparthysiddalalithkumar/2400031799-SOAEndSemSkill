package com.example.jwt.model;

import java.util.Map;

public class JwtRequest {
    private Map<String, Object> payload;

    public JwtRequest() {
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }
}
