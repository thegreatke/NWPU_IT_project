package com.library.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReaderCard implements Serializable {  //Serializable是可序列对象的标识

    private long reader_id;
    private String username;
    private String password;
    private long already_lend_num;

}
