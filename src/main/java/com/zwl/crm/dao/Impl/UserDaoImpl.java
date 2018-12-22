package com.zwl.crm.dao.Impl;

import com.zwl.crm.dao.UserDao;
import com.zwl.crm.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public void save(User user) {
        if (this.getHibernateTemplate() != null) {
            this.getHibernateTemplate().save(user);
        }else {
            System.out.println("hibernate空指针！！");
        }
    }
}
