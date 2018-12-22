package com.zwl.crm.service;

import com.zwl.crm.domain.User;

public interface UserService {
    void regist(User user);

    User login(User user);
}
