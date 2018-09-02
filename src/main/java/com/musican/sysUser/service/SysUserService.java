package com.musican.sysUser.service;

import com.musican.Utils.ReturnMessage;
import com.musican.Utils.ServiceUtils;
import com.musican.Utils.StringUtils;
import com.musican.sysUser.dao.SysUserMapper;
import com.musican.sysUser.model.SysUser;
import com.musican.userInfo.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class SysUserService extends ServiceUtils<SysUserMapper,SysUser> implements ISysUserService{
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    IUserInfoService userInfoService;

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

    @Override
    public ReturnMessage regist(SysUser sysUser) {
        try {
            super.save(sysUser);
            sysUser.getUserInfo().setUserId(sysUser.getId());
            if(sysUser.getUserInfo().getAddress().length != 0){
                sysUser.getUserInfo().setUserInfoAddress(StringUtils.join(sysUser.getUserInfo().getAddress()));
            }
            userInfoService.save(sysUser.getUserInfo());
            ReturnMessage returnMessage = new ReturnMessage(ReturnMessage.CODE_SUCCESS);
            return returnMessage;
        }catch (Exception e){
            ReturnMessage returnMessage = new ReturnMessage(ReturnMessage.CODE_FIAL);
            e.printStackTrace();
            return returnMessage;
        }
    }
}
