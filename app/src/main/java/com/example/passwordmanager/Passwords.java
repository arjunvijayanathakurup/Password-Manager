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

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
