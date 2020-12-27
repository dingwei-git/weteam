package com.login.dao;

import com.common.bean.test1;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {

    public test1 login();

}
