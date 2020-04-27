package com.java.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
@Slf4j
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    private static MessageSource messageSource;

    public static String getMessage(String key, String params) {
       Object [] param={params};
       return getMessage(key,param);
    }

    /**
     * 获取国际化资源
     */
    public static String getMessage(String key, Object[] params) {
        checkApplicationContext();
        String value="";
        try {
            value=messageSource.getMessage(key,params, Locale.CHINA);
        }catch (Exception e){
            log.error("获取国际化参数时异常",e);
        }
        return value;
    }

    public static String getMessage(String key) {
        return getMessage(key,"");
    }
    /**
     * 从静态变量Applicationcontext中取得bean 自动转型为所赋值对象的类型
     */
    public static <T> T getBean(Class<T> tClass) {
        checkApplicationContext();
        return applicationContext.getBean(tClass);
    }

    /**
     * 检测applicationcontext注入
     */
    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicationcontext未注入，请在springcontextholder创建后再初始化次工具");
        }
        if (messageSource == null) {
            messageSource = applicationContext.getBean(MessageSource.class);
        }

    }

    private static synchronized void setApplication(ApplicationContext application) {
        applicationContext = application;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }



    /**
     * 实现ApplicationContextAware接口的Context注入函数 将其存入静态变量
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        if (applicationContext != null) {
            setApplication(applicationContext);
        }
    }

    /**
     * springutil判空处理
     *
     */
    public static boolean hasLength(String token) {
        if (token == null || token.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean hasLength(List<?> token) {
        if (token == null || token.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}
