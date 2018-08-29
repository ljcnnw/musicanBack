package com.musican.userInfo.model;

import java.util.Date;

public class UserInfo {
    private String id;

    private String userId;

    private String userInfoName;

    private String userInfoTel;

    private String userInfoEmail;

    private String userInfoSign;

    
    private String userInfoIntro;

    private String bandInfoId;

    private String dynInfoId;

    private String musicStyle;

    private Date createDate;

    private Date updateDate;

    private String delFlag;

    private String createUser;

    private String updateUser;

    private String userInfoImg;

    private String userInfoAddress;

    public String getUserInfoAddress() {
        return userInfoAddress;
    }

    public void setUserInfoAddress(String userInfoAddress) {
        this.userInfoAddress = userInfoAddress;
    }

    public String getUserInfoImg() {
        return userInfoImg;
    }

    public void setUserInfoImg(String userInfoImg) {
        this.userInfoImg = userInfoImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserInfoName() {
        return userInfoName;
    }

    public void setUserInfoName(String userInfoName) {
        this.userInfoName = userInfoName == null ? null : userInfoName.trim();
    }

    public String getUserInfoTel() {
        return userInfoTel;
    }

    public void setUserInfoTel(String userInfoTel) {
        this.userInfoTel = userInfoTel == null ? null : userInfoTel.trim();
    }

    public String getUserInfoEmail() {
        return userInfoEmail;
    }

    public void setUserInfoEmail(String userInfoEmail) {
        this.userInfoEmail = userInfoEmail == null ? null : userInfoEmail.trim();
    }

    public String getUserInfoSign() {
        return userInfoSign;
    }

    public void setUserInfoSign(String userInfoSign) {
        this.userInfoSign = userInfoSign == null ? null : userInfoSign.trim();
    }

    public String getUserInfoIntro() {
        return userInfoIntro;
    }

    public void setUserInfoIntro(String userInfoIntro) {
        this.userInfoIntro = userInfoIntro == null ? null : userInfoIntro.trim();
    }

    public String getBandInfoId() {
        return bandInfoId;
    }

    public void setBandInfoId(String bandInfoId) {
        this.bandInfoId = bandInfoId == null ? null : bandInfoId.trim();
    }

    public String getDynInfoId() {
        return dynInfoId;
    }

    public void setDynInfoId(String dynInfoId) {
        this.dynInfoId = dynInfoId == null ? null : dynInfoId.trim();
    }

    public String getMusicStyle() {
        return musicStyle;
    }

    public void setMusicStyle(String musicStyle) {
        this.musicStyle = musicStyle == null ? null : musicStyle.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }
}