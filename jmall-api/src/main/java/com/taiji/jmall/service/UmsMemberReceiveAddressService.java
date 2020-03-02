package com.taiji.jmall.service;

import com.taiji.jmall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UmsMemberReceiveAddressService {
    List<UmsMemberReceiveAddress> getUmsMemberReceiveAddressByUserId(String userId);
}
