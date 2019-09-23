package com.library.service;

import com.library.bean.Book;
import com.library.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public ArrayList<Book> queryBook(String searchWord) {
        return bookDao.queryBook(searchWord);
    }



    public ArrayList<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public boolean matchBook(String searchWord) {
        return bookDao.matchBook(searchWord) > 0;
    }// 判断大于0代表的是否执行成功

    public boolean addBook(Book book) {
        return bookDao.addBook(book) > 0;
    }//返回的int是数据库执行操作后影响的行数

    public Book getBook(Long bookId) {
        return bookDao.getBook(bookId);
    }

    public boolean editBook(Book book) {
        return bookDao.editBook(book) > 0;
    }

    public boolean deleteBook(Long bookId) {
        return bookDao.deleteBook(bookId) > 0;
    }



}
