package com.example.libary.controller;

import com.example.libary.model.User;
import com.example.libary.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    // 透過建構子注入 UserService
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    
    // 模擬登入
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        System.out.println("User '" + username + "' attempting to log in.");
        // TODO: 實作完整的 Spring Security 登入與 JWT 權杖發行邏輯
        return ResponseEntity.ok(Map.of("token", "fake-jwt-token-for-" + username));
    }


    // 註冊端點 (修改後)
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User userInfo) {
        System.out.println("Registering new user: " + userInfo.getUsername());
        
        try {
            // 呼叫 UserService 處理實際的註冊邏輯
            userService.registerNewUser(userInfo);
            
            // 如果成功，回傳一個包含成功訊息的 JSON 物件，狀態碼為 200 OK
            return ResponseEntity.ok(Map.of("message", "註冊成功！正在為您跳轉..."));
            
        } catch (IllegalArgumentException e) {
            // 如果使用者名稱已存在或其他業務邏輯錯誤，回傳 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(Map.of("message", "註冊失敗：" + e.getMessage()));
        } catch (Exception e) {
            // 處理其他未預期的錯誤，回傳 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("message", "註冊失敗：伺服器內部錯誤。"));
        }
    }
}
