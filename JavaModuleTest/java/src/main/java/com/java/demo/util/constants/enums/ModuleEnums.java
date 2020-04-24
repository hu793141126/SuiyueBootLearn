package com.java.demo.util.constants.enums;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 *
 */
@AllArgsConstructor
public enum ModuleEnums {
    //模块枚举
    USER(1, "加载成功"),
    ;
    @Setter
    private  int moduleId;

    @Setter
    private String moduleName;


    public int getModuleId() {
        return moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }
}
