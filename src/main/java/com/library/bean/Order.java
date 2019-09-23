package com.library.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Order implements Serializable {

    private long order_id;
    private long reader_id;
    private long book_id;
    private Date order_date;
    private Date order_date_deadline;

}

