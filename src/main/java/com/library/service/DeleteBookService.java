package com.library.service;

import com.library.bean.delete_list;
import com.library.dao.DeleteBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DeleteBookService {

    @Autowired
    private DeleteBookDao deleteBookDao;


    // TODO: 2019/9/23  实现记录管理删除书籍的操作，保存到数据库的List列表中去。

    public ArrayList<delete_list> getDeleteList()

}
