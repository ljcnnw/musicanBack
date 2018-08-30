package com.musican.sysUser.dao;

import com.musican.Utils.IDaoUtils;
import com.musican.sysUser.model.SysUser;

import java.util.List;


public interface SysUserMapper  extends IDaoUtils<SysUser>{
    int deleteByPrimaryKey(String id);


    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> findList();

    SysUser login(SysUser sysUser);
}