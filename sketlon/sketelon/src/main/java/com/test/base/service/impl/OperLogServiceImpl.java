package com.test.base.service.impl;


import com.test.base.bean.OperLog;
import com.test.base.constants.CodeConstants;
import com.test.base.dao.OperLogMapper;
import com.test.base.service.OperLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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
