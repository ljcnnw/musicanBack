package com.musican.sysUser.service;

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
}
