package com.ana.xworlds.entity;

/**
 * Created by Ana on 2/18/2016.
 */
public class User {
    public String login;
    public String password;
    public String deviceType;
    public String deviceId;

    public User(String login, String password, String deviceId) {
        this.login = login;
        this.password = password;
        this.deviceType = String.format("%s %s",
                android.os.Build.MODEL, android.os.Build.VERSION.RELEASE);
        this.deviceId = deviceId;
    }
}
