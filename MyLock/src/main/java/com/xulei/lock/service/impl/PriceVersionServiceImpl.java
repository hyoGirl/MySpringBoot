package com.xulei.lock.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xulei.lock.dao.PriceMapper;
import com.xulei.lock.dao.PriceVersionMapper;
import com.xulei.lock.entity.Price;
import com.xulei.lock.entity.PriceVersion;
import com.xulei.lock.service.PriceVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/25 23:14
 * @Version 1.0
 */
@Service
public class PriceVersionServiceImpl extends ServiceImpl<PriceVersionMapper,PriceVersion> implements PriceVersionService {


    @Autowired
    PriceVersionMapper priceVersionMapper;

    @Override
    public int updateByVersion(PriceVersion priceVersion) {
        return  priceVersionMapper.updateLock(priceVersion);
    }
}
