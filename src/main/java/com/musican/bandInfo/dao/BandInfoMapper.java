package com.musican.bandInfo.dao;

import com.musican.bandInfo.model.BandInfo;

public interface BandInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(BandInfo record);

    int insertSelective(BandInfo record);

    BandInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BandInfo record);

    int updateByPrimaryKey(BandInfo record);
}