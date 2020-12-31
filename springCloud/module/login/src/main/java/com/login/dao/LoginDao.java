package com.login.dao;

import com.common.bean.AddressBean;
import com.common.dataSource.DataSourceEnum;
import com.common.dataSource.DataSourceSelect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
@DataSourceSelect(DataSourceEnum.management)
public interface LoginDao {

    public List<AddressBean> login();

}
