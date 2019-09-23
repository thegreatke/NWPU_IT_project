package com.library.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Lend implements Serializable {

    private long ser_num;
    private long book_id;
    private long reader_id;
    private Date lend_date;
    private Date back_date;
    private Data back_date_deadline;
    private long fine_money;

}
