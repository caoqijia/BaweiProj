package com.bawei.baweiproj.network.entity;

public class UserLoginReqEntity {

    /**
     * username : sample string 1
     * pwd : sample string 2
     */

    private String username;
    private String pwd;

    public UserLoginReqEntity(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
