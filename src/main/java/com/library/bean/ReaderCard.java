package com.library.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReaderCard implements Serializable {  //Serializable是可序列对象的标识

    private long readerId;
    private String name;
    private String password;
    private int alreadyLend;

}
