package com.linksharing.dto;

/**
 * Created by karan on 18/7/17.
 */
public class LoginDTO {

    private String loginId;
    private String loginPass;


    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    public LoginDTO(){}
}
