package com.mybatis.plus.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mybatis.plus.entity.Plus;
public interface PlusMapper extends BaseMapper<Plus>{
	
	
	List<Map<String,Object>> findPlusPage(Page<Plus> page);
	

}
