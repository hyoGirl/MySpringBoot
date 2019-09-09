package com.xulei.rabbitmq.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xulei.rabbitmq.code.entity.MsgLog;

import java.util.Date;
import java.util.List;

public interface MsgLogService extends IService<MsgLog>{


    void updateStatus(String msgId, Integer status);

    MsgLog selectByMsgId(String msgId);

    List<MsgLog> selectTimeoutMsg();

    void updateTryCount(String msgId, Date tryTime);


}
