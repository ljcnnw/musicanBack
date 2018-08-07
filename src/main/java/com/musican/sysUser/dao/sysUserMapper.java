package com.musican.sysUser.dao;

import com.musican.sysUser.model.sysUser;

public interface sysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(sysUser record);

    int insertSelective(sysUser record);

    sysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(sysUser record);

    int updateByPrimaryKey(sysUser record);
}