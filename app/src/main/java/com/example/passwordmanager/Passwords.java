package com.example.passwordmanager;

public class Passwords {
    private String mailId;
    private String password;
    private String name;
    private String url;
    private String username;

    public Passwords(String mailId, String password, String name, String url, String username){
        this.mailId = mailId;
        this.password = password;
        this.name = name;
        this.url = url;
        this.username = username;
    }
}
