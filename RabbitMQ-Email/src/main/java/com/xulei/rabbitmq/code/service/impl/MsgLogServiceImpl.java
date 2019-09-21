package com.xulei.rabbitmq.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xulei.rabbitmq.code.dao.MsgLogDao;
import com.xulei.rabbitmq.code.entity.MsgLog;
import com.xulei.rabbitmq.code.service.MsgLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/8 10:31
 * @Version 1.0
 */
@Service
public class MsgLogServiceImpl extends ServiceImpl<MsgLogDao,MsgLog> implements MsgLogService {


    @Autowired
    MsgLogDao msgLogDao;



    @Override
    public void updateStatus(String msgId, Integer status) {

        MsgLog msgLog = selectByMsgId(msgId);
        msgLog.setStatus(status);
        msgLog.setUpdateTime(new Date());
        this.updateById(msgLog);
    }

    @Override
    public MsgLog selectByMsgId(String msgId) {
        return msgLogDao.selectOne(new QueryWrapper<MsgLog>().eq("msg_id", msgId));
    }

    @Override
    public List<MsgLog> selectTimeoutMsg() {
        return null;
    }

    @Override
    public void updateTryCount(String msgId, Date tryTime) {

        MsgLog msgLog = msgLogDao.selectById(msgId);
        msgLog.setTryCount(msgLog.getTryCount()+1);
        msgLog.setUpdateTime(new Date());
        msgLogDao.updateById(msgLog);
    }
}
