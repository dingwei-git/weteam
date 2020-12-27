package com.login.service.impl;

import com.common.bean.test1;
import com.common.redis.RedisUtil;
import com.login.dao.LoginDao;
import com.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao LoginDao;

    @Autowired
    private RedisUtil redis;

    @Override
    public String login() {
        test1 test = LoginDao.login();
        String aaa = redis.getValue("aaa");
        return test.getId()+"======"+test.getName();
    }
}
