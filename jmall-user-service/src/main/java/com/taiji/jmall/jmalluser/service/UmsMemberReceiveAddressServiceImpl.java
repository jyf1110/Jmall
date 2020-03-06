package com.taiji.jmall.jmalluser.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.taiji.jmall.bean.UmsMemberReceiveAddress;
import com.taiji.jmall.jmalluser.mapper.UmsMemberReceiveAddressMapper;
import com.taiji.jmall.service.UmsMemberReceiveAddressService;
 import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {
    @Reference
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;
    @Override
    public List<UmsMemberReceiveAddress> getUmsMemberReceiveAddressByUserId(String userId) {
        Example example =new Example(UmsMemberReceiveAddress.class);
        example.createCriteria().andEqualTo("memberId",userId);
        return umsMemberReceiveAddressMapper.selectByExample(example);
 //            UmsMemberReceiveAddress umsMemberReceiveAddress=new UmsMemberReceiveAddress();
//             umsMemberReceiveAddress.setMemberId(userId);
//            return umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
    }
}
