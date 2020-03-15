package com.taiji.jmall.jmalluser.mapper;

import com.taiji.jmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}
