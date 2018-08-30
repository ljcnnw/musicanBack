package com.musican.Utils;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public abstract class CurrencyBean {
    protected String id;

    protected Date createDate;

    protected Date updateDate;

    protected String delFlag;

    protected String createUser;

    protected String updateUser;

    public CurrencyBean() {
        super();
        this.delFlag = "0";
    }

    /**
     * 保存之前插入
     */
    public void preInsert(){
        if( !StringUtils.isNotBlanks(id)){
            this.id = StringUtils.uuid();
        }
        if (createDate == null){
            this.createDate  = new Date();
        }
        if(updateDate == null){
            this.updateDate = new Date();
        }
    }

    /**
     * 更新之前插入
     */
    public void preUpdate(){
        this.updateDate = new Date();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
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
        this.delFlag = delFlag;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
