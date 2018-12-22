package com.zwl.crm.service;

import com.zwl.crm.domain.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> findByTypeCode(String dict_type_code);
}
