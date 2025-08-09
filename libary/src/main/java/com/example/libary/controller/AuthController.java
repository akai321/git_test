package com.example.libary.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // 模擬登入
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        System.out.println("User '" + username + "' attempting to log in.");
        // TODO: 實作完整的 Spring Security 登入與 JWT 權杖發行邏輯
        return ResponseEntity.ok(Map.of("token", "fake-jwt-token-for-" + username));
    }

    // 模擬註冊
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> userInfo) {
        System.out.println("Registering new user: " + userInfo.get("username"));
        // TODO: 實作使用者帳號建立、密碼加密儲存等邏輯
        return ResponseEntity.ok("User registered successfully!");
    }
}
