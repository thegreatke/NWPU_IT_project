package com.library.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class delete_list implements Serializable {
    private long adminId;
    private String Isbn;
    private Date deleteDate;
    /*
    type = 0,代表删除一本书，那本书的副本减一即可
    type = 1,代表下架那本书的所有副本，那本书的副本变为0，并且下架
     */
    private long deleteType;
    private String deleteReason;
    private int bookId;
}
