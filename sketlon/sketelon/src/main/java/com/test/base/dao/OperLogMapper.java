package com.test.base.dao;

import com.test.base.bean.OperLog;

import java.util.List;

public interface OperLogMapper {

    List<OperLog> selectByPrimaryIds(List<Integer> ids);

    List<OperLog> selectAll();

    int deleteByPrimaryKey(Integer operLogId);

    int insert(OperLog record);

    int insertSelective(OperLog record);

    OperLog selectByPrimaryKey(Integer operLogId);

    int updateByPrimaryKeySelective(OperLog record);

    int updateByPrimaryKey(OperLog record);
}