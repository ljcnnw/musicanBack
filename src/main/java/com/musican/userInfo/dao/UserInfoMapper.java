package com.musican.userInfo.dao;

import com.musican.Utils.CurrencyBean;
import com.musican.Utils.DaoUtils;
import com.musican.Utils.IDaoUtils;
import com.musican.userInfo.model.UserInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserInfoMapper extends IDaoUtils<CurrencyBean> {
    int deleteByPrimaryKey(String id);


    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    @Select("select * from user_info")
    @Results({
            @Result(column = "id" ,property = "id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "user_info_name",property = "userInfoName"),
            @Result(column = "user_info_tel",property = "userInfoTel"),
            @Result(column = "user_info_email",property = "userInfoEmail"),
            @Result(column = "user_info_sign",property = "userInfoSign"),
            @Result(column = "user_info_intro",property = "userInfoIntro")
    })
    List<UserInfo> findPage();
}