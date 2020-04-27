package com.java.demo.controller.log;

import com.java.demo.model.log.OperLog;
import com.java.demo.service.log.LogService;
import com.java.demo.util.aop.ControllerLog;
import com.java.demo.util.base.BaseController;
import com.java.demo.util.base.WebResult;
import com.java.demo.util.constants.enums.ModuleEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController extends BaseController {
    @Resource
    private LogService operLogService;

    @ControllerLog(module = ModuleEnums.USER,logDesc = "user.test")
    @GetMapping("/insert-operlog")
    public WebResult insertOperLog(OperLog operLog)  {
        WebResult webResult=new WebResult();
        Map<String,Object> data=new HashMap<>(16);
        int code = operLogService.insertlog(operLog);
        encapsulateData(webResult,data,"");
        webResult.setCode(code);
        return webResult;
    }

    @ControllerLog(module = ModuleEnums.USER,logDesc = "user.test")
    @GetMapping("/test-log")
    public WebResult testOperLog() {
        WebResult webResult=new WebResult();
        Map<String,Object> data=new HashMap<>(16);
        int code = operLogService.testLog(data);
        encapsulateData(webResult,data,"");
        webResult.setCode(code);
        return webResult;
    }
}
