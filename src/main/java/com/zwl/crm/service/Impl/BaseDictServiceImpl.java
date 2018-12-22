package com.zwl.crm.service.Impl;

import com.zwl.crm.dao.BaseDictDao;
import com.zwl.crm.domain.BaseDict;
import com.zwl.crm.service.BaseDictService;

import java.util.List;

public class BaseDictServiceImpl implements BaseDictService {

    private BaseDictDao baseDictDao;
    public void setBaseDictDao(BaseDictDao baseDictDao) {
    }

    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {
        return baseDictDao.findByTypeCode(dict_type_code);
    }
}
