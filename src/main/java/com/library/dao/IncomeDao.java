package com.library.dao;


import com.library.bean.Income;
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


    public ArrayList<Income> getAllIncome() {
        List<Income> result = sqlSessionTemplate.selectList(NAMESPACE + "getAllIncome");
        return (ArrayList<Income>) result;
    }






}
