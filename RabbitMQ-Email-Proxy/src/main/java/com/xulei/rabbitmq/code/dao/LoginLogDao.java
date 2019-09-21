package com.xulei.rabbitmq.code.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xulei.rabbitmq.code.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginLogDao extends BaseMapper<LoginLog> {
}
