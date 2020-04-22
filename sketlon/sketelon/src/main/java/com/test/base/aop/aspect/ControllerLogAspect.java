package com.test.base.aop.aspect;

import com.test.base.aop.ControllerLog;
import com.test.base.bean.OperLog;
import com.test.base.bean.WebResult;
import com.test.base.constants.CodeConstants;
import com.test.base.constants.enums.Module;
import com.test.base.service.OperLogService;
import com.test.base.service.impl.OperLogServiceImpl;
import com.test.base.util.AddressUtils;
import com.test.base.util.SpringUtil;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 日志切面
 *
 * @author hyhua
 * @date 2019/7/17
 */
@Component
@Aspect
@Slf4j
@SuppressWarnings("all")
public class ControllerLogAspect {
    /**
     * 声明切点
     * 已注解的出现的地方为切点
     */
    @Pointcut("@annotation(com.test.base.aop.ControllerLog)")
    public  void controllerAspect(){
        log.info("@annotation(com.test.base.aop.ControllerLog)");
    }

    /**
     * 声明环绕式方法内容
     * @param proceedingJoinPoint
     * @return
     */
    @Around("controllerAspect()")
    public Object doAroundJob(ProceedingJoinPoint proceedingJoinPoint){
        Object retval;
        //通过切点获取具体的方法
        Signature signature=proceedingJoinPoint.getSignature();
        MethodSignature methodSignature=(MethodSignature) signature;
        Method method=methodSignature.getMethod();
        try{
            //控制层请求方法执行前逻辑--暂无
            retval=proceedingJoinPoint.proceed();//放行方法获取方法返回结果
            //控制层请求方法执行后逻辑--↓↓↓↓
        }catch (Throwable e){
            retval=new WebResult();
            log.info("发生了未捕获的异常",e);
        }
        ServletRequestAttributes requestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=requestAttributes.getRequest();
        /**
         * 判断web
         */
        if (retval instanceof WebResult){
            WebResult webResult=(WebResult) retval;
            saveOperationLog(webResult,request,method);
        }
        return  retval;
    }

    private void saveOperationLog(WebResult webResult, HttpServletRequest request, Method method) {
        log.info("");
        ControllerLog logs=method.getAnnotation(ControllerLog.class);
        OperLogService operLogService= SpringUtil.getBean(OperLogServiceImpl.class);
        OperLog operLog=new OperLog();
        operLog.setUserName("admin");
        //Nginx中有反向代理 可通过头信息x-forwarded-for获取真实ip
        String logigip=request.getHeader("x-forwarded-for");
        //正常获取IP
        if (!SpringUtil.hasLength(logigip)){
            logigip=request.getRemoteAddr();
        }
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        //浏览器名
        Browser browser = userAgent.getBrowser();
        //操作系统名
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        operLog.setLogDevice(browser.getName() + " -- " + operatingSystem.getName());
        operLog.setUserIp(logigip);
        operLog.setLogLocation(AddressUtils.getAddress(logigip));
        operLog.setLogTime(new Date());
        Module module = logs.module();
        String action=SpringUtil.getMessage(logs.logDesc());
        operLog.setLogOper(action);
        int result= CodeConstants.THE_RESPOND_IS_FIELD;
        if (CodeConstants.THE_RESPOND_IS_SUCCESS.equals(webResult.getCode())){
            result=CodeConstants.THE_RESPOND_IS_SUCCESS;
        }
        operLog.setLogStatus(result);
        operLog.setLogCode(webResult.getCode());
        operLog.setLogDesc(webResult.getLogs());
        operLogService.insertOperlog(operLog);
    }

}
