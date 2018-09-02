package com.musican.userInfo.service;

import com.musican.Utils.ReturnMessage;
import com.musican.Utils.ServiceUtils;
import com.musican.sysUser.model.SysUser;
import com.musican.sysUser.service.ISysUserService;
import com.musican.userInfo.dao.UserInfoMapper;
import com.musican.userInfo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService extends ServiceUtils<UserInfoMapper,UserInfo> implements IUserInfoService  {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    ISysUserService sysUserService;

    @Override
    public List<UserInfo> findPage() {
        return userInfoMapper.findPage();
    }


    @Override
    public ReturnMessage regist(SysUser sysUser) {
        try {
            sysUserService.regist(sysUser);
            ReturnMessage returnMessage = new ReturnMessage(ReturnMessage.CODE_SUCCESS);
            return returnMessage;
        }catch (Exception e){
            ReturnMessage returnMessage = new ReturnMessage(ReturnMessage.CODE_FIAL);
            e.printStackTrace();
            return returnMessage;
        }
    }
}
