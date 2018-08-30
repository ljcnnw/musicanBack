package com.musican.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class ServiceUtils<D extends IDaoUtils,T extends CurrencyBean> {
    @Autowired
    protected D dao;

    @Transactional(readOnly = false)
    public void save(T entity){
        entity.preInsert();
        dao.insert(entity);
    }

}
