package com.example.libary.service;

import com.example.libary.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // 模擬一個簡單的註冊邏輯
    public void registerNewUser(User user) {
        // 在這裡可以加入檢查使用者名稱是否已存在、密碼加密等邏輯
        // 為了演示，我們假設註冊總是成功
        if ("existing_user".equals(user.getUsername())) {
             throw new IllegalArgumentException("使用者名稱已存在");
        }
        
        System.out.println("成功註冊新使用者: " + user.getUsername());
        // 實際應用中，這裡會是 save() 到資料庫
    }
}