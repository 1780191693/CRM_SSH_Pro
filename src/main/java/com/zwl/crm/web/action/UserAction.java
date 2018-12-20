package com.zwl.crm.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zwl.crm.domain.User;
import com.zwl.crm.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String user_regist(User user){
        userService.regist(user);
        return LOGIN;
    }
}
