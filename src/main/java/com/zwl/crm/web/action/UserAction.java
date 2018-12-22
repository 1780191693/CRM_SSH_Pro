package com.zwl.crm.web.action;

import com.opensymphony.xwork2.ActionContext;
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

    public String user_regist() throws Exception {
        userService.regist(user);
        return SUCCESS;
    }

    public String user_login() throws Exception{
        User login = userService.login(user);
        if (login == null){
            this.addActionError("用户名或密码错误!");
            return LOGIN;
        }else {
            ActionContext.getContext().getSession().put("existUser",login);
            return SUCCESS;
        }
    }

}
