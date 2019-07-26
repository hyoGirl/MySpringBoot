package com.xulei.lock.service;

import com.baomidou.mybatisplus.service.IService;
import com.xulei.lock.entity.Price;
import com.xulei.lock.entity.PriceVersion;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/25 23:13
 * @Version 1.0
 */
public interface PriceVersionService extends IService<PriceVersion> {

    int updateByVersion(PriceVersion priceVersion);
}
