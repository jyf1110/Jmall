package com.taiji.jmall.jmalluser.service.impl;

 import com.alibaba.dubbo.config.annotation.Service;
import com.taiji.jmall.bean.UmsMember;
import com.taiji.jmall.jmalluser.mapper.UserMapper;
import com.taiji.jmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


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
