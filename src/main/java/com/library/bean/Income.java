package com.library.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Income {

    private long BookId;
    private String type;
    private long readerId;
    private float value;
    private Date date_time;



}
