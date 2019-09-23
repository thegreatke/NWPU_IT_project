package com.library.bean;

import lombok.Data;

@Data
public class Admin {

    private long admin_id;
    private String password;
    private String username;
    private int roles;

}
