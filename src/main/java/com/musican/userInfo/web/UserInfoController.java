package com.musican.userInfo.web;

import com.musican.userInfo.model.UserInfo;
import com.musican.userInfo.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("userInfo")
public class UserInfoController {
    @Autowired
    IUserInfoService userInfoService;

    @GetMapping("findPage")
    public List<UserInfo> findPage(){
        return userInfoService.findPage();
    }

}
