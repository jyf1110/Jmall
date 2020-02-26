package com.taiji.jmall.jmalluser.mapper;

import com.taiji.jmall.jmalluser.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}
