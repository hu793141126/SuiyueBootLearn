package com.test.base.aop;

import com.test.base.constants.enums.Module;

import java.lang.annotation.*;

/**
 * 控制层自定义注解
 *
 * @author David
 * @date 2019/7/17
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLog {
    Module module() ;
    String logDesc() default "";
}
