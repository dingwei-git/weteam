package com.login.service.impl;

import com.common.bean.AddressBean;
import com.common.bean.CodeManageBean;
import com.common.redis.RedisUtil;
import com.common.utils.RestResult;
import com.login.dao.LoginDao;
import com.login.dao.LoginsDao;
import com.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;

    @Autowired
    LoginsDao loginsDao;

    @Autowired
    private RedisUtil redis;

    @Override
    public RestResult login() {
        RestResult restResult = new RestResult();
        List<AddressBean> list = loginDao.login();
        restResult.setData(list);
        return restResult;
    }

    @Override
    public RestResult logins() {
        RestResult restResult = new RestResult();
        List<CodeManageBean> list = loginsDao.login();
        restResult.setData(list);
        return restResult;
    }
}
