package com.musican.sysDict.dao;

import com.musican.sysDict.model.sysDict;

public interface sysDictMapper {
    int deleteByPrimaryKey(String id);

    int insert(sysDict record);

    int insertSelective(sysDict record);

    sysDict selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(sysDict record);

    int updateByPrimaryKey(sysDict record);
}