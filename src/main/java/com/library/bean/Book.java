package com.library.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Book implements Serializable {

    private long BookId;
    private String name;
    private String author;
    private String publish;
    private String Isbn;
    private String introduction;
    private String language;
    private BigDecimal price;
    private Date Pubdate;
    private int ClassId;
    private int number;
}