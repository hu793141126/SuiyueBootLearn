package com.java.demo.service.log.impl;


import com.java.demo.dao.log.OperLogMapper;
import com.java.demo.model.log.OperLog;
import com.java.demo.service.log.OperLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("OperLogService")
@Slf4j
public class OperLogServiceImpl implements OperLogService {
    @Resource
    OperLogMapper operLogMapper;

    private static final String OPERLOG_TITLE="export.operlog.title";

    @Override
    public int insertOperlog(OperLog operLog) {
        int insert = operLogMapper.insert(operLog);
        return insert;
    }
}
