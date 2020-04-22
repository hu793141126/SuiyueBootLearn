package com.test.sketelon.bean;

import com.test.base.bean.BaseModel;
import lombok.Data;

@Data
public class User extends BaseModel {
    private Integer id;

    private String username;

    private String password;

}