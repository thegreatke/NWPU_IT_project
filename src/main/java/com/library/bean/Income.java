package com.library.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Income {


    public enum Type{
        fine , deposit
    }

    private long BookId;
    private Type  type;
    private long readerId;
    private float value;
    private Date date_time;


}
