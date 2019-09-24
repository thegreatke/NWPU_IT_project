package com.library.dao;


import com.library.bean.Income;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
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


    public int addIncome(final Income income) {
//        income.setType(Income.Type.fine);
        return sqlSessionTemplate.insert(NAMESPACE + "addIncome", income);
    }


    // TODO: 2019-09-23 返回某一天的所有收入记录的list
    public List<Income> getDayIncome(Date  date) {


        List<Income> incomeArrayList = new ArrayList<Income>();
        incomeArrayList =  sqlSessionTemplate.selectList(NAMESPACE + "getDayIncome", date);

        return incomeArrayList;

    }


    // TODO: 2019-09-23 ......月。。。。。
    public float getMonthIncome(int  month) {
        return sqlSessionTemplate.insert(NAMESPACE + "addIncome", month);
    }



}
