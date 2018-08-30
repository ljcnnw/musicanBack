package com.musican.sysUser.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.musican.Utils.CurrencyBean;
import com.musican.userInfo.model.UserInfo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.util.Date;

public class SysUser extends CurrencyBean {


    private String userName;

    private String userPass;

    private UserInfo userInfo;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }


}