package com.musican.sysUser.service;

import com.musican.Utils.ReturnMessage;
import com.musican.sysUser.model.SysUser;

import java.util.List;

public interface ISysUserService {
    List<SysUser> findList();
    ReturnMessage login(SysUser sysUser);
    ReturnMessage regist(SysUser sysUser);
    ReturnMessage checkUserName(String id);
    ReturnMessage sendEmail() throws Exception;
//    ReturnMessage test();
}
