package com.java.demo.util.aop;

import com.java.demo.util.constants.enums.ModuleEnums;
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
    ModuleEnums module() ;
    String logDesc() default "";
}
