package com.musican.sysUser.service;

import com.musican.Utils.ReturnMessage;
import com.musican.Utils.ServiceUtils;
import com.musican.Utils.StringUtils;
import com.musican.sysUser.dao.SysUserMapper;
import com.musican.sysUser.model.SysUser;
import com.musican.userInfo.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class SysUserService extends ServiceUtils<SysUserMapper, SysUser> implements ISysUserService {
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
        if (user == null) {
            returnMessage.setMessage("用户名密码错误");
            returnMessage.setSuccess(false);
        } else {
            returnMessage.setSuccess(true);
            returnMessage.setData(user);
        }
        return returnMessage;
    }

    @Override
    public ReturnMessage regist(@RequestBody SysUser sysUser) {
        ReturnMessage message = new ReturnMessage(ReturnMessage.CODE_FIAL);
        if (!StringUtils.isNotBlanks(sysUser.getUserName())) {
            message.setMessage("用户名为空");
            return message;
        } else if (!StringUtils.isNotBlanks(sysUser.getUserPass())) {
            message.setMessage("密码为空");
            return message;
        } else if (sysUser.getUserInfo() == null || !StringUtils.isNotBlanks(sysUser.getUserInfo().getUserInfoEmail())) {
            message.setMessage("邮箱为空");
            return message;
        } else if (sysUser.getUserName().length() < 8) {
            message.setMessage("用户名长度不能小于8个字符");
            return message;
        } else if (sysUser.getUserName().length() > 20) {
            message.setMessage("用户名长度不能超过20个字符");
            return message;
        } else if (sysUser.getUserPass().length() < 8) {
            message.setMessage("密码长度不能小于8个字符");
            return message;
        } else {
            ReturnMessage m = checkUserName(sysUser.getUserName());
            if (!m.isSuccess()) {
                message.setMessage(m.getMessage());
                return message;
            }
            super.save(sysUser);
            sysUser.getUserInfo().setUserId(sysUser.getId());
            userInfoService.save(sysUser.getUserInfo());
            message.setSuccess(true);
            message.setCode(ReturnMessage.CODE_SUCCESS);
            message.setMessage("注册成功");
            return message;
        }
//        try {
//            super.save(sysUser);
//            sysUser.getUserInfo().setUserId(sysUser.getId());
//            if(sysUser.getUserInfo().getAddress().length != 0){
//                sysUser.getUserInfo().setUserInfoAddress(StringUtils.join(sysUser.getUserInfo().getAddress()));
//            }
//            userInfoService.save(sysUser.getUserInfo());
//            ReturnMessage returnMessage = new ReturnMessage(ReturnMessage.CODE_SUCCESS);
//            return returnMessage;
//        }catch (Exception e){
//            ReturnMessage returnMessage = new ReturnMessage(ReturnMessage.CODE_FIAL);
//            e.printStackTrace();
//            return returnMessage;
//        }
    }

    @Override
    public ReturnMessage checkUserName(String userName) {
        List<SysUser> list = sysUserMapper.getByUserName(userName);
        ReturnMessage message = new ReturnMessage();
        if (list == null || list.size() == 0) {
            message.setCode(ReturnMessage.CODE_SUCCESS);
            message.setSuccess(true);
        } else {
            message.setCode(ReturnMessage.CODE_FIAL);
            message.setSuccess(false);
            message.setMessage("用户名重复");
        }
        return message;
    }
}
