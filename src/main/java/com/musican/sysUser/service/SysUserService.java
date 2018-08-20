package com.musican.sysUser.service;

import com.musican.Utils.ReturnMessage;
import com.musican.sysUser.dao.SysUserMapper;
import com.musican.sysUser.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService implements ISysUserService{
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findList() {

        return sysUserMapper.findList();
    }

    @Override
    public ReturnMessage login(SysUser sysUser) {
        ReturnMessage returnMessage = new ReturnMessage();
        SysUser user = sysUserMapper.login(sysUser);
        if(user == null){
            returnMessage.setMessage("用户名密码错误");
            returnMessage.setSuccess(false);
        }else {
            returnMessage.setSuccess(true);
            returnMessage.setData(user);
        }
        return returnMessage;
    }
}
