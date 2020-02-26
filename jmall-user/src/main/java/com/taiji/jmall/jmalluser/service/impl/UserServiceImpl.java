package com.taiji.jmall.jmalluser.service.impl;

import com.taiji.jmall.jmalluser.bean.UmsMember;
import com.taiji.jmall.jmalluser.mapper.UserMapper;
import com.taiji.jmall.jmalluser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
     UserMapper userMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> allUser=userMapper.selectAllUser();
        return allUser;
    }
}
