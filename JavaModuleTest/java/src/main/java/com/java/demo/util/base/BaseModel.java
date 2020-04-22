package com.java.demo.util.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 通用
 * 实体分页以及前后端分离数据处理
 * 基础类
 */
@Getter
@Setter
public class BaseModel implements Serializable {
    /*
    每页显示大小 默认10条 只允许写  不允许转json   分页参数
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer size = 10;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer page = 1;
    @JsonIgnore
    private Integer start;
    @JsonIgnore
    private Long startTime;
    @JsonIgnore
    private Long endTime;

    /*
    start设置时考虑无顺序的情况
   */
    public void setSize(Integer size) {
        this.size = size;
        setStartByPageSize();
    }


    public void setPage(Integer page) {
        this.page = page;
        setStartByPageSize();
    }

    public void setStartByPageSize() {
        if ((page != null) && (size != null)) {
            this.start = (page - 1) * size;
        }
    }

    /*
    前后端分离-返回前端数据处理  list为前端传递的分页参数
   */
    public void formatData(Map<String, Object> data, List list) {
        //默认第一页 条数0条
        long total = 0;
        int realPage = 1;
        //判空处理-
        if ((list == null || list.isEmpty())) {
            data.put("list", new ArrayList<>());
            data.put("total", total);
            data.put("page", realPage);
            return;
        }
        //通过分页插件获取总数与真实的页数
        if (list instanceof Page) {
            total = ((Page) list).getTotal();
            realPage = ((Page) list).getPageNum();
        } else {
            total = list.size();
        }
        //填充数据
        data.put("list", list);
        data.put("total", total);
        data.put("page", realPage);
    }

    /**
     * 包装WebResult结果集
     */
}


