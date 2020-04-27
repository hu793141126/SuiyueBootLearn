package com.java.demo.util.constants.enums;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * 模块枚举--用枚举方便  但是对国际化支持不太友好
 */
@AllArgsConstructor
public enum CodeEnums {
    //通用接口返回
    THE_RESPONSE_SUCCESS(0, "操作成功"),
    THE_RESPONSE_UNKNOW(-1,"未知异常")
    ;
    @Setter
    private  int code;

    @Setter
    private String message;


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }}
