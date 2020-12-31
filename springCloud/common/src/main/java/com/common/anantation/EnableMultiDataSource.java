package com.common.anantation;

import com.common.dataSource.DataSourceConfiguration;
import com.common.dataSource.MethodDynamicDataSourceAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({MethodDynamicDataSourceAspect.class, DataSourceConfiguration.class})
public @interface EnableMultiDataSource {
}
