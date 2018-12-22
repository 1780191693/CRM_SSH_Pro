package com.zwl.crm.dao.Impl;

import com.zwl.crm.dao.UserDao;
import com.zwl.crm.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    public void save(User user) {
        if (this.getHibernateTemplate() != null) {
            this.getHibernateTemplate().save(user);
        }else {
            System.out.println("hibernate空指针！！");
        }
    }

    @Override
    public User login(User user) {
        if (this.getHibernateTemplate() != null) {
            List<User> list = (List<User>) this.getHibernateTemplate().find("from User u where u.user_code = ?0 and u.user_password = ?1", user.getUser_code(), user.getUser_password());
            if (list.size() > 0){
                return list.get(0);
            }
        }
        return null;
    }
}
