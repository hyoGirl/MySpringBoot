package com.xulei.lock.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xulei.lock.dao.PriceMapper;
import com.xulei.lock.entity.Price;
import com.xulei.lock.service.PriceService;
import org.springframework.stereotype.Service;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/7/25 23:14
 * @Version 1.0
 */
@Service
public class PriceServiceImpl extends ServiceImpl<PriceMapper,Price> implements PriceService {
}
