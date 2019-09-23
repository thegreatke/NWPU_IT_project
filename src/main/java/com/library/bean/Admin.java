package com.library.bean;

import lombok.Data;

@Data
public class Admin {

    private long adminId;
    private String password;
    private String username;
    private int roles;

}
