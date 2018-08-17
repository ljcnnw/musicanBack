package com.musican.bandInfo.model;

import java.util.Date;

public class BandInfo {
    private String id;

    private String bandName;

    private String bandStyle;

    private String bandIntro;

    private String bandPeople;

    private Date createDate;

    private Date updateDate;

    private String delFlag;

    private String createUser;

    private String updateUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName == null ? null : bandName.trim();
    }

    public String getBandStyle() {
        return bandStyle;
    }

    public void setBandStyle(String bandStyle) {
        this.bandStyle = bandStyle == null ? null : bandStyle.trim();
    }

    public String getBandIntro() {
        return bandIntro;
    }

    public void setBandIntro(String bandIntro) {
        this.bandIntro = bandIntro == null ? null : bandIntro.trim();
    }

    public String getBandPeople() {
        return bandPeople;
    }

    public void setBandPeople(String bandPeople) {
        this.bandPeople = bandPeople == null ? null : bandPeople.trim();
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