package com.common.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.common.dataSource.dataSourceProperties.DemandProperties;
import com.common.dataSource.dataSourceProperties.ManagementProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfiguration {
    @Autowired
    ManagementProperties managementProperties;
    @Autowired
    DemandProperties demandProperties;

    public DataSource management(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(managementProperties.getUrl());
        datasource.setUsername(managementProperties.getUsername());
        datasource.setPassword(managementProperties.getPassword());
        datasource.setDriverClassName(managementProperties.getDriverClassName());
        datasource.setInitialSize(managementProperties.getInitialSize());
        datasource.setMinIdle(managementProperties.getMinIdle());
        datasource.setMaxActive(managementProperties.getMaxActive());
        datasource.setMaxWait(managementProperties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(managementProperties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(managementProperties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(managementProperties.getValidationQuery());
        datasource.setTestWhileIdle(managementProperties.getTestWhileIdle());
        datasource.setTestOnBorrow(managementProperties.getTestOnBorrow());
        datasource.setTestOnReturn(managementProperties.getTestOnReturn());
        datasource.setPoolPreparedStatements(managementProperties.getPoolPreparedStatements());
        datasource.setMaxOpenPreparedStatements(managementProperties.getMaxOpenPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(managementProperties.getMaxPoolPreparedStatementPerConnectionSize());
        datasource.setBreakAfterAcquireFailure(managementProperties.getBreakAfterAcquireFailure());
        datasource.setConnectionErrorRetryAttempts(managementProperties.getConnectionErrorRetryAttempts());
        return datasource;
    }
    public DataSource demand(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(demandProperties.getUrl());
        datasource.setUsername(demandProperties.getUsername());
        datasource.setPassword(demandProperties.getPassword());
        datasource.setDriverClassName(demandProperties.getDriverClassName());
        datasource.setInitialSize(demandProperties.getInitialSize());
        datasource.setMinIdle(demandProperties.getMinIdle());
        datasource.setMaxActive(demandProperties.getMaxActive());
        datasource.setMaxWait(demandProperties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(demandProperties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(demandProperties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(demandProperties.getValidationQuery());
        datasource.setTestWhileIdle(demandProperties.getTestWhileIdle());
        datasource.setTestOnBorrow(demandProperties.getTestOnBorrow());
        datasource.setTestOnReturn(demandProperties.getTestOnReturn());
        datasource.setPoolPreparedStatements(demandProperties.getPoolPreparedStatements());
        datasource.setMaxOpenPreparedStatements(demandProperties.getMaxOpenPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(demandProperties.getMaxPoolPreparedStatementPerConnectionSize());
        datasource.setBreakAfterAcquireFailure(demandProperties.getBreakAfterAcquireFailure());
        datasource.setConnectionErrorRetryAttempts(demandProperties.getConnectionErrorRetryAttempts());
        return datasource;
    }


    @Primary
    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setDefaultTargetDataSource(management());
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put("management",management());
        dsMap.put("demand",demand());
        dataSource.setTargetDataSources(dsMap);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
