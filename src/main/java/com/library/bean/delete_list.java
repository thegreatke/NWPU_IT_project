package com.library.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class delete_list implements Serializable {
    private long admin_id;
    private String Isbn;
    private Date delete_date;
    /*

     */
    private long delete_type;
}
