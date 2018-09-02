package com.musican.userInfo.service;

import com.musican.Utils.ReturnMessage;
import com.musican.sysUser.model.SysUser;
import com.musican.userInfo.model.UserInfo;
import org.apache.catalina.User;

import java.util.List;

public interface IUserInfoService {
    List<UserInfo> findPage();
    void save(UserInfo userInfo);
    ReturnMessage regist(SysUser sysUser);

}
