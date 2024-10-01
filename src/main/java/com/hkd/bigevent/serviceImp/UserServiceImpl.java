package com.hkd.bigevent.serviceImp;

import com.hkd.bigevent.mapper.UserMapper;
import com.hkd.bigevent.pojo.User;
import com.hkd.bigevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public Integer register(String username, String password) {
        return userMapper.register(username,password);
    }
}
