package com.musican.userInfo.service;

import com.musican.Utils.ReturnMessage;
import com.musican.sysUser.model.SysUser;
import com.musican.userInfo.model.UserInfo;

import java.util.List;

public interface IUserInfoService {
    List<UserInfo> findPage();

    ReturnMessage regist(UserInfo userInfo, SysUser sysUser);

}
