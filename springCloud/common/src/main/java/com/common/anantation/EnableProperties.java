package com.common.anantation;

import com.common.dataSource.dataSourceProperties.DemandProperties;
import com.common.dataSource.dataSourceProperties.ManagementProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({ManagementProperties.class,DemandProperties.class})
public @interface EnableProperties {
}
