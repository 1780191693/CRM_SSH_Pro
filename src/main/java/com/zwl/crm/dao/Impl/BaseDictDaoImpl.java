package com.zwl.crm.dao.Impl;

import com.zwl.crm.dao.BaseDictDao;
import com.zwl.crm.domain.BaseDict;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {

    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {
        return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict b where b.dict_type_code = ?0 ",dict_type_code);
    }
}
