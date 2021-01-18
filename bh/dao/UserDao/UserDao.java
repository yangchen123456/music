package com.bh.dao.UserDao;

import com.bh.pojo.User;

import java.io.IOException;

public interface UserDao {

    //登录

    public boolean login(String name,String pass);

    //注册
    public void sign(User user);

    // 验证用户名是否存在
    public boolean login(String name);

}
