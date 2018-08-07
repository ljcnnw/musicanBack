package com.musican.bandInfo.dao;

import com.musican.bandInfo.model.bandInfo;

public interface bandInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(bandInfo record);

    int insertSelective(bandInfo record);

    bandInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(bandInfo record);

    int updateByPrimaryKey(bandInfo record);
}