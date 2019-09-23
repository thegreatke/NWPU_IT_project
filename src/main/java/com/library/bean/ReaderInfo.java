package com.library.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReaderInfo implements Serializable {

    private long readerId;
    private String name;
    private String sex;
    private Date birth;
    private String address;
    private String phone;
    private String email;

}
