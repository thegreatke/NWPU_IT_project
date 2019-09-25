package com.library.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Book implements Serializable {

    private long bookId;
    private String name;
    private String author;
    private String publish;
    private String isbn;
    private String introduction;
    private String language;
    private float price;
    private Date pubdate;
    private int classId;
    private int number;
    private String location;

}
