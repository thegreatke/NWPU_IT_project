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

    public ArrayList<delete_list> getDeleteList() {
        return deleteBookDao.getDeleteList();
    }

    public boolean addDeleteBook(delete_list deleteBook) {
        return deleteBookDao.addDeleteBook(deleteBook) > 0;
    }//返回的int是数据库执行操作后影响的行数

    public delete_list getDeleteBook(String  ISBN) {
        return deleteBookDao.getDeleteBook(ISBN);
    }

    public delete_list getDeleteBookByBookId(int book_id){
        return deleteBookDao.getDeleteBookByBookId(book_id);
    }

    public boolean editDeleteBook(delete_list deleteBook) {
        return deleteBookDao.editDeleteBook(deleteBook) > 0;
    }

    public boolean deleteDeleteBook(String ISBN) {
        return deleteBookDao.deleteDeleteBook(ISBN) > 0;
    }

}
