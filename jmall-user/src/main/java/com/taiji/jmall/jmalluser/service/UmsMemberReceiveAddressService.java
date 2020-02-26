package com.taiji.jmall.jmalluser.service;

import com.taiji.jmall.jmalluser.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UmsMemberReceiveAddressService {
    List<UmsMemberReceiveAddress> getUmsMemberReceiveAddressByUserId(String userId);
}
