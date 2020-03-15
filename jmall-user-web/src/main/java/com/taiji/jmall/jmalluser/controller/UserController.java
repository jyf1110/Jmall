package com.taiji.jmall.jmalluser.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.taiji.jmall.bean.UmsMember;
import com.taiji.jmall.bean.UmsMemberReceiveAddress;
import com.taiji.jmall.service.UmsMemberReceiveAddressService;
import com.taiji.jmall.service.UserService;
 import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Reference
    UserService userService;

    @Reference
    UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    @RequestMapping("index")
    @ResponseBody
    public String sayHello(){
        return "hello";
    }
    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> allUser=userService.getAllUser();
        return allUser;
    }
    @RequestMapping("getUmsMemberReceiveAddressByUserId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getUmsMemberReceiveAddressByUserId(String userId){
         List<UmsMemberReceiveAddress> umsMemberReceiveAddressList=umsMemberReceiveAddressService.getUmsMemberReceiveAddressByUserId(userId);
        return umsMemberReceiveAddressList;
    }
}
