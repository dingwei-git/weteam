package com.login.dao;

import com.common.bean.CodeManageBean;
import com.common.dataSource.DataSourceEnum;
import com.common.dataSource.DataSourceSelect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
@DataSourceSelect(DataSourceEnum.demand)
public interface LoginsDao {

    public List<CodeManageBean> login();

}
