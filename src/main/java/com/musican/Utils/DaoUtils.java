package com.musican.Utils;

import com.musican.userInfo.model.UserInfo;
import org.springframework.util.StringUtils;

public class DaoUtils<T> implements IDaoUtils{

    private T data;


    public void insert(CurrencyBean currencyBean){
        if (StringUtils.isEmpty(currencyBean.getId()))
        {
            currencyBean.setId(com.musican.Utils.StringUtils.uuid());
        }else if(StringUtils.isEmpty(currencyBean.getDelFlag())){
            currencyBean.setDelFlag("0");
        }
    }

}
