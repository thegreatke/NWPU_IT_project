package com.library.dao;

import com.library.bean.delete_list;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DeleteBookDao {

    private final static String NAMESPACE = "com.library.dao.DeleteBookDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public ArrayList<delete_list> getDeleteList() {
        List<delete_list> result = sqlSessionTemplate.selectList(NAMESPACE + "getDeleteList");
        return (ArrayList<delete_list>) result;
    }

    public int addDeleteBook(final delete_list deleteBook) {
        return sqlSessionTemplate.insert(NAMESPACE + "addDeleteBook", deleteBook);
    }

    public delete_list getDeleteBook(final String isbn) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getDeleteBook", isbn);
    }

    public delete_list getDeleteBookByBookId(final int book_id){
        return sqlSessionTemplate.selectOne(NAMESPACE + "getDeleteBookByBookId", book_id);
    }


    public int editDeleteBook(final delete_list deleteBook) {
        return sqlSessionTemplate.update(NAMESPACE + "editDeleteBook", deleteBook);
    }

    public int deleteDeleteBook(final String isbn) {
        return sqlSessionTemplate.delete(NAMESPACE + "deleteDeleteBook", isbn);
    }




}
