package com.hkd.bigevent.service;

import com.hkd.bigevent.pojo.User;

public interface UserService {
    //根据用户名查询用户
    public User findUserByName(String username);
    //注册用户
    public Integer register(String username,String password);
    public Integer update(User user);
}
