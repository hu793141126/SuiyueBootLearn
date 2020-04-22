package com.test.base.constants.enums;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 *
 */
@AllArgsConstructor
public enum Module implements BaseEnums {
    USER(0, "加载成功"),
    ;
    @Setter
    private  int code;

    @Setter
    private String info;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getInfo() {
        return info;
    }
}
