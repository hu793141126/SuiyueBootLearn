package com.java.demo.util.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.demo.util.SpringUtil;
import lombok.Data;

/**
 *  返回前端的web模型类
 */
@Data
public class WebResult {
    //状态吗
    private Integer code;
    //返回给前端的数据
    private Object data;
    //状态码对应的描述
    private String message;
    //日志描述--如需记录操作详细信息可封装此log
    @JsonIgnore
    private String logs;

    /**
     * setCode的同时初始化message
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
        String message = SpringUtil.getMessage(code.toString());
        this.message=message;
    }
}
