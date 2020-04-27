package com.java.demo.service.log;


import com.java.demo.model.log.OperLog;

import java.util.Map;

public interface LogService {
    Integer insertlog(OperLog operLog);
    Integer testLog(Map<String,Object> data);
}
