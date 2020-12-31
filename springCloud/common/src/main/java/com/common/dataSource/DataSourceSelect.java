package com.common.dataSource;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface DataSourceSelect {

    DataSourceEnum value() default DataSourceEnum.management;
}
