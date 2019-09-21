package com.xulei.rabbitmq.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xulei.rabbitmq.code.dao.LoginLogDao;
import com.xulei.rabbitmq.code.entity.LoginLog;
import com.xulei.rabbitmq.code.service.LoginLogService;
import org.springframework.stereotype.Service;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/21 12:47
 * @Version 1.0
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogDao,LoginLog> implements LoginLogService {
}
