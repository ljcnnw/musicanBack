package com.musican.userInfo.web;

import com.musican.Utils.ReturnMessage;
import com.musican.sysUser.model.SysUser;
import com.musican.userInfo.model.UserInfo;
import com.musican.userInfo.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("userInfo")
public class UserInfoController {
    @Autowired
    IUserInfoService userInfoService;

    @GetMapping("findPage")
    public List<UserInfo> findPage() {
        return userInfoService.findPage();
    }

    @PostMapping("regist")
    public ReturnMessage regist(@RequestBody UserInfo userInfo,@RequestBody SysUser sysUser) {
        return userInfoService.regist(userInfo, sysUser);
    }
}
