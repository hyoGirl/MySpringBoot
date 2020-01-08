package com.mybatis.plus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.entity.Plus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlusMapper extends BaseMapper<Plus> {
	
	
	List<Map<String,Object>> findPlusPage(Page<Plus> page);
	

}
