package com.musican.userInfo.service;

import com.musican.userInfo.dao.UserInfoMapper;
import com.musican.userInfo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService implements IUserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findPage() {
        return userInfoMapper.findPage();
    }
}
