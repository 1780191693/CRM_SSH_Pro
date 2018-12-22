package com.zwl.crm.dao;

import com.zwl.crm.domain.BaseDict;

import java.util.List;

public interface BaseDictDao {
    List<BaseDict> findByTypeCode(String dict_type_code);
}
