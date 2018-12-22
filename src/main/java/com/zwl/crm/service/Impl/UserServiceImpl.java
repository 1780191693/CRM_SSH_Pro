package com.zwl.crm.service.Impl;

import com.zwl.crm.Utils.MD5Utils;
import com.zwl.crm.dao.UserDao;
import com.zwl.crm.domain.User;
import com.zwl.crm.service.UserService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void regist(User user) {
        //密码加密处理
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        user.setUser_state("1");
        userDao.save(user);
    }

    @Override
    public User login(User user) {
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        return userDao.login(user);
    }
}
