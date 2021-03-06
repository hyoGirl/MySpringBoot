package com.mybatis.plus.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mybatis.plus.entity.Plus;

public interface PlusService extends IService<Plus> {

	void insertPlus(Plus plus);

	Plus getPlus(int id);

	Page<Plus> findAllPlusPage(Page<Plus> page);

	void deletePlus(int id);
}
