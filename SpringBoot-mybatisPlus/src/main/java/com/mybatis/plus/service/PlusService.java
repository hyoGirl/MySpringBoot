package com.mybatis.plus.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.mybatis.plus.entity.Plus;

public interface PlusService extends IService<Plus>{

	void insertPlus(Plus plus);

	Plus getPlus(int id);

	Page<Plus> findAllPlusPage(Page<Plus> page);

}
