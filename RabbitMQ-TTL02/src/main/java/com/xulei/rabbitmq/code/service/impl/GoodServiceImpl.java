package com.xulei.rabbitmq.code.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xulei.rabbitmq.code.entity.Good;
import com.xulei.rabbitmq.code.mapper.GoodMapper;
import com.xulei.rabbitmq.code.service.GoodService;
import org.springframework.stereotype.Service;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/10/14 22:57
 * @Version 1.0
 */
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper,Good> implements GoodService{
}
