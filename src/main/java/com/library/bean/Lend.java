package com.library.bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Lend implements Serializable {

    private long serNum;
    private long bookId;
    private long readerId;
    private Date lendDate;
    private Date backDate;
    private Data backDateDeadline;
    private long fineMoney;

}
