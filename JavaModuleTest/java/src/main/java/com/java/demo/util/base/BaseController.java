package com.java.demo.util.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

/**
 * 基础控制层
 * CrossOrigin 解决跨域问题
 */
@CrossOrigin
@Getter
@Setter
public class BaseController {
    public void encapsulateData(WebResult webResult, Map<String,Object> data,String desc){
        webResult.setData(data);
        webResult.setLogs(desc);
    }
}
