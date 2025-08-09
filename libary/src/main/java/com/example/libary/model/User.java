package com.example.libary.model;

// 這個類別會自動被 Spring Boot 用來轉換 JSON 資料
public class User {
    private String username;
    private String password;
    private String email;

    // 必須要有無參數的建構子
    public User() {}

    // getter 和 setter 方法是必要的，讓 Spring Boot 能存取屬性
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}