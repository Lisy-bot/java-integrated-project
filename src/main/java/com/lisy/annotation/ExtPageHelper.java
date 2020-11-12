package com.lisy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auto: Lisy
 * @Date: 16
 * @Description:
 * @Version: 1.0
 */
//整合mybatis分页插件
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExtPageHelper {
    int pageSize() default 20;
}
