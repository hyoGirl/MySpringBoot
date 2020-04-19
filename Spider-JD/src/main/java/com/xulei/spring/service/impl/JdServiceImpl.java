package com.xulei.spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xulei.spring.dao.JdMapper;
import com.xulei.spring.model.JdModel;
import com.xulei.spring.service.JdService;
import org.springframework.stereotype.Service;

/**
 * @ClassName JdServiceImpl
 * @description TODO
 * @author XULEI
 * @Date 2020/4/19 23:10 
 * @Version 1.0
 */
@Service
public class JdServiceImpl extends ServiceImpl<JdMapper,JdModel> implements JdService {
}
