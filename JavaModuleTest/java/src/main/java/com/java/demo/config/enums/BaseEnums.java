package com.java.demo.config.enums;

/**
 * 枚举根接口
 *
 * @author Tellsea
 * @date 2019/8/5
 */
public interface BaseEnums {

    /**
     * 获得标记key
     *
     * @return key
     */
    int getCode();

    /**
     * 获得消息 value
     *
     * @return value
     */
    String getInfo();
}
