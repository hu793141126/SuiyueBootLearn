package com.java.demo.util;

import com.java.demo.util.constants.enums.CodeEnums;


/** 枚举工具类 */
public class EnumUtil {

    /** 通过code获取枚举*/
    public static CodeEnums getEnumByCode(Integer code, Class<CodeEnums> enumClass) {
        for (CodeEnums each : enumClass.getEnumConstants()) {
            if(code.equals(each.getCode())){
                return  each;
            }
        }
        return null;
    }
}