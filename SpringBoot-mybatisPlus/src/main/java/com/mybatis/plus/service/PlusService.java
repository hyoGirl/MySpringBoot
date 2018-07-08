package com.mybatis.plus.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mybatis.plus.dao.PlusMapper;
import com.mybatis.plus.entity.Plus;

@Service
public class PlusService extends ServiceImpl<PlusMapper,Plus>{
	
	@Autowired
	private PlusMapper plusMapper;
	
	
	/**
	 * 
	 * 说明： 新增
	 * @param plus
	 * @author 徐磊
	 * @time：2018年5月16日 下午5:55:37
	 */
	public void insertPlus(Plus plus){
		plusMapper.insert(plus);
	}
	
	/**
	 * 
	 * 说明：查询一个
	 * @param id
	 * @return
	 * @author 徐磊
	 * @time：2018年5月16日 下午5:55:48
	 */
	public Plus getPlus(int id){
		Plus plus = plusMapper.selectById(id);
		return plus;
	}
	
	/**
	 * 
	 * 说明：删除
	 * @param id
	 * @return
	 * @author 徐磊
	 * @time：2018年5月16日 下午5:57:21
	 */
	public Integer deletePlus(int id){
		Integer count = plusMapper.deleteById(id);
		return count;
	}
	
	/**
	 * 
	 * 说明：修改
	 * @param plus
	 * @return
	 * @author 徐磊
	 * @time：2018年5月16日 下午5:58:22
	 */
	public Integer updatePlus(Plus plus){
		
		Integer count = plusMapper.updateById(plus);
		return count;
	}
	
	/**
	 * 
	 * 说明：测试分页
	 * @param page
	 * @return
	 * @author 徐磊
	 * @time：2018年5月13日 下午8:49:04
	 */
	public Page<Plus>  findAllPlusPage(Page<Plus> page){
		//不需要条件来进行分页
		//List<Plus> list = plusMapper.selectList(null);
		//不采用条件进行分页
		List<Plus> lstUser = plusMapper.selectPage(page, null);
		
		page.setRecords(lstUser);
		
		return page;
	}
	
	/**
	 * 说明：测试分页02
	 * @param page
	 * @return
	 * @author 徐磊
	 * @time：2018年5月21日 下午2:29:23
	 */
	public Page<Plus>  findAllPage(Page<Plus> page){
		
		
		List<Map<String, Object>> result = plusMapper.findPlusPage(page);
		
		//page.setRecords((List<Plus>)result);
		return page;
	}
	
}
