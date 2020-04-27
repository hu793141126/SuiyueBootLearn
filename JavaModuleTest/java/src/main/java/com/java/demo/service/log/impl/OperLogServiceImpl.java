package com.java.demo.service.log.impl;


import com.java.demo.dao.log.OperLogMapper;
import com.java.demo.model.log.OperLog;
import com.java.demo.service.log.LogService;
import com.java.demo.util.constants.enums.CodeEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("OperLogService")
@Slf4j
public class OperLogServiceImpl implements LogService {
    @Resource
    OperLogMapper operLogMapper;

    private static final String OPERLOG_TITLE="export.operlog.title";

    @Override
    public Integer insertlog(OperLog operLog) {
        int insert = operLogMapper.insert(operLog);
        return insert;
    }

    @Override
    public Integer testLog(Map<String, Object> data) {
        List<OperLog> operLogs = operLogMapper.selectAll();
        data.put("data",operLogs);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CodeEnums.THE_RESPONSE_SUCCESS.getCode();
    }
}
