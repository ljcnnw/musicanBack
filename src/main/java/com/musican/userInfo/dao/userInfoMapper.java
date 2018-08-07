package com.musican.userInfo.dao;

import com.musican.userInfo.model.userInfo;

public interface userInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(userInfo record);

    int insertSelective(userInfo record);

    userInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(userInfo record);

    int updateByPrimaryKey(userInfo record);
}