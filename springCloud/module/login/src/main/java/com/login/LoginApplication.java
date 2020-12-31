package com.login;

import com.common.anantation.EnableMultiDataSource;
import com.common.dataSource.DataSourceConfiguration;
import com.common.dataSource.dataSourceProperties.DemandProperties;
import com.common.dataSource.dataSourceProperties.ManagementProperties;
import com.common.redis.RedisUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableMultiDataSource
@Import({ManagementProperties.class, DemandProperties.class,RedisUtil.class, DataSourceConfiguration.class})
public class LoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

}
