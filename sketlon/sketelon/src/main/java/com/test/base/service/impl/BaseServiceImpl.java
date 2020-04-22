package com.test.base.service.impl;

import com.test.base.dao.BaseMapper;
import com.test.base.service.BaseService;
import javax.annotation.Resource;

/**
 * 基类接口实现类
 *
 * @param <T>实体对应的Mapper
 * @author Tellsea
 * @date 2019/8/6
 */
public class BaseServiceImpl<T> implements BaseService<T> {
    @Resource
    protected BaseMapper<T> baseMapper;
}
