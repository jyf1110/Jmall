package com.taiji.jmall.jmalluser.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.taiji.jmall.bean.UmsMember;
import com.taiji.jmall.jmalluser.mapper.UserMapper;
import com.taiji.jmall.service.UserService;


import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Reference
     UserMapper userMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> allUser=userMapper.selectAllUser();
        return allUser;
    }
}
