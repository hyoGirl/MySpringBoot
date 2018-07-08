package com.xulei.sevice.impl;

import com.xulei.dao.UserInfoDao;
import com.xulei.entity.UserInfo;
import com.xulei.sevice.UserInfoService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}