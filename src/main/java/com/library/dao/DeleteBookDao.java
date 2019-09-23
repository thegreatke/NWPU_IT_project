package com.library.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class DeleteBookDao {
    private final static String NAMESPACE = "com.library.dao.DeleteBookDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;




}
