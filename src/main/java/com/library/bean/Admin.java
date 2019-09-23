package com.library.bean;

import lombok.Data;

@Data
public class Admin {

    // TODO: 2019/9/23  新增属性roles, int类型

    private long admin_id;
    private String password;
    private String username;
    private int roles;

}
