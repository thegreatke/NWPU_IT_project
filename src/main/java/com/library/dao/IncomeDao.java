package com.library.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IncomeDao {

    private final static String NAMESPACE = "com.library.dao.IncomeDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;


    public ArrayList<ReaderInfo> getAllReaderInfo() {
        List<ReaderInfo> result = sqlSessionTemplate.selectList(NAMESPACE + "getAllReaderInfo");
        return (ArrayList<ReaderInfo>) result;
    }




}
