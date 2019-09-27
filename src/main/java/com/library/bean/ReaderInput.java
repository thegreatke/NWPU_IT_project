package com.library.bean;


import lombok.Data;

import java.util.Date;

@Data
public class ReaderInput {

    private long readerId;
    private String name;
    private String username;
    private String password;
    private String sex;
    private Date birth;
    private String address;
    private String phone;
    private String email;

}
