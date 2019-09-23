package com.library.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class lib_notice implements Serializable {

    private long id;
    private String content;
    private Date dateTime;

}
