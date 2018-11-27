package com.zcy.hello.springboot.mybatis.mapper;

import com.zcy.hello.springboot.mybatis.entity.TbUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

public interface TbUserMapper extends MyMapper<TbUser> {
}