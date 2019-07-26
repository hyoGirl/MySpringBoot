package com.xulei.lock.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xulei.lock.entity.PriceVersion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PriceVersionMapper extends BaseMapper<PriceVersion> {


    int updateLock(PriceVersion priceVersion);
}
