package com.youknowwho.androidclient;

public class UserInfo {
    public final String url;
    public final String username;
    public final String email;
    public final boolean is_staff;

    public UserInfo(String url, String username, String email, boolean is_staff) {
        this.url = url;
        this.username = username;
        this.email = email;
        this.is_staff = is_staff;
    }
}
