package com.java.demo.model.log;

import com.java.demo.util.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class OperLog extends BaseModel {
    /**
     * 日志ID
     */
    private Integer operLogId;
    /**
     * 日志时间
     */
    private Date logTime;
    /**
     * 操作动作
     * 增删改查-其他
     */
    private String logOper;
    /**
     * 操作状态
     */
    private String logStatus;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户IP
     */
    private String userIp;
    /**
     * 用户位置描述
     */
    private String logLocation;
    /**
     * 访问环境
     */
    private String logDevice;
    /**
     * 状态码
     */
    private Integer logCode;
    /**
     * 花费时间
     */
    private Double spendTime;
    /**
     * 日志描述
     */
    private String logDesc;

}