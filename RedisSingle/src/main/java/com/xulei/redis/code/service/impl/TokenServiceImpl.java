package com.xulei.redis.code.service.impl;

import com.xulei.redis.code.service.TokenService;
import com.xulei.redis.util.RandomUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String createToken() {

        String str = RandomUtil.UUID32();



        return null;
    }

    @Override
    public void checkToken(HttpServletRequest request) {

    }
}
