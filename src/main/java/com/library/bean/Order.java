package com.library.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Order implements Serializable {

    private long orderId;
    private long readerId;
    private long bookId;
    private Date orderDate;    //秒级别
    private Date orderDateDeadline; //秒级别

}

