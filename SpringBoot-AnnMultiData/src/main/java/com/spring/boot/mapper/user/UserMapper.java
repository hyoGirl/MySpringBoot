package com.spring.boot.mapper.user;

import com.spring.boot.pojo.User;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User>{

    void addUser(User user);

    User findUserById(@Param("id")Long id);
}
