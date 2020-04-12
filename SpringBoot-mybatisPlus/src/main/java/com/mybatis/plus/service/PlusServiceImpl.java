package com.mybatis.plus.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.plus.dao.PlusMapper;
import com.mybatis.plus.entity.Plus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlusServiceImpl extends ServiceImpl<PlusMapper,Plus> implements PlusService{
	
	@Autowired
	private PlusMapper plusMapper;

	@Override
	@Transactional(propagation= Propagation.REQUIRED)
	public void insertPlus(Plus plus) {
		plusMapper.insert(plus);
//		int a=100/0;
//		System.out.println("本次测试没有事务");
		deletePlus(58);
//		PlusService plusService = (PlusService) AopContext.currentProxy();
//		plusService.deletePlus(49);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
//	@Transactional
	public void deletePlus(int id) {
		System.out.println("本次测试有事务");
		plusMapper.deleteById(id);
		int a=100/0;
	}





	@Override
	public Plus getPlus(int id) {
		Plus plus = plusMapper.selectById(id);
		return plus;
	}

	@Override
	public Page<Plus> findAllPlusPage(Page<Plus> page) {
		//不需要条件来进行分页
		//List<Plus> list = plusMapper.selectList(null);
		//不采用条件进行分页
//		List<Plus> lstUser = plusMapper.selectPage(page, null);

//		IPage<Plus> plusIPage = plusMapper.selectPage(page, null);
//
//		page.setRecords(lstUser);
//
//		return page;
		return null;
	}


	//	/**
//	 * 
//	 * 说明： 新增
//	 * @param plus
//	 * @author 徐磊
//	 * @time：2018年5月16日 下午5:55:37
//	 */
//	@Transactional
//	public void insertPlus(Plus plus){
//		plusMapper.insert(plus);
//		int a=100/0;
//	}
//	
//	/**
//	 * 
//	 * 说明：查询一个
//	 * @param id
//	 * @return
//	 * @author 徐磊
//	 * @time：2018年5月16日 下午5:55:48
//	 */
//	public Plus getPlus(int id){
//		Plus plus = plusMapper.selectById(id);
//		return plus;
//	}
//	
//	/**
//	 * 
//	 * 说明：删除
//	 * @param id
//	 * @return
//	 * @author 徐磊
//	 * @time：2018年5月16日 下午5:57:21
//	 */
//	public Integer deletePlus(int id){
//		Integer count = plusMapper.deleteById(id);
//		return count;
//	}
//	
//	/**
//	 * 
//	 * 说明：修改
//	 * @param plus
//	 * @return
//	 * @author 徐磊
//	 * @time：2018年5月16日 下午5:58:22
//	 */
	public Integer updatePlus(Plus plus){
		
		Integer count = plusMapper.updateById(plus);
		return count;
	}
//	
//	/**
//	 * 
//	 * 说明：测试分页
//	 * @param page
//	 * @return
//	 * @author 徐磊
//	 * @time：2018年5月13日 下午8:49:04
//	 */
//	public Page<Plus>  findAllPlusPage(Page<Plus> page){
//		//不需要条件来进行分页
//		//List<Plus> list = plusMapper.selectList(null);
//		//不采用条件进行分页
//		List<Plus> lstUser = plusMapper.selectPage(page, null);
//		
//		page.setRecords(lstUser);
//		
//		return page;
//	}
//	
//	/**
//	 * 说明：测试分页02
//	 * @param page
//	 * @return
//	 * @author 徐磊
//	 * @time：2018年5月21日 下午2:29:23
//	 */
//	public Page<Plus>  findAllPage(Page<Plus> page){
//		
//		
//		List<Map<String, Object>> result = plusMapper.findPlusPage(page);
//		
//		//page.setRecords((List<Plus>)result);
//		return page;
//	}
	
}
